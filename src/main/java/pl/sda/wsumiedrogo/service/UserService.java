package pl.sda.wsumiedrogo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.wsumiedrogo.mappers.UserMapper;
import pl.sda.wsumiedrogo.model.User;
import pl.sda.wsumiedrogo.model.dto.UserDto;
import pl.sda.wsumiedrogo.repositories.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }
    public UserDto getUserById(Long id) {
        return userRepository.findById(id)
                .map(user -> userMapper.userToUserDto(user))
                .orElseThrow(ResourceNotFoundException::new);
    }

    public UserDto getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(user -> userMapper.userToUserDto(user))
                .orElseThrow(ResourceNotFoundException::new);
    }

    public User createNewUser(User user) {
        User userToSave = userRepository.save(user);

        return userToSave;
    }

}