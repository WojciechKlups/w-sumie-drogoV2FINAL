package pl.sda.wsumiedrogo.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.wsumiedrogo.mappers.UserMapper;
import pl.sda.wsumiedrogo.model.User;
import pl.sda.wsumiedrogo.model.dto.UserDto;
import pl.sda.wsumiedrogo.repositories.UserRepository;
import pl.sda.wsumiedrogo.service.registration.RegistrationEmailService;

@Service
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;
    private RegistrationEmailService emailService;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper, RegistrationEmailService emailService) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.emailService = emailService;
    }
    public UserDto getUserById(Long id) {
        return userRepository.findById(id)
                .map(user -> userMapper.userToUserDto(user))
                .orElseThrow(ResourceNotFoundException::new);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(ResourceNotFoundException::new);
    }

    public void createNewUser(User user) throws EmailException {
        String newActivationCode = RandomStringUtils.randomAlphanumeric(15);
        user.setActivationCode(newActivationCode);
        emailService.sendAuthenticationEmail(user);
        userRepository.save(user);
    }

    public void authenticate(String activationCode){
        User byActivationCode = userRepository.findByActivationCode(activationCode);
        byActivationCode.setActivated(true);
        userRepository.save(byActivationCode);
    }

}