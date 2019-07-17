package pl.sda.wsumiedrogo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import pl.sda.wsumiedrogo.model.User;
import pl.sda.wsumiedrogo.repositories.UserRepository;
@Configuration
public class EventListener {

    private UserRepository userRepository;

    @Autowired
    public EventListener(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @org.springframework.context.event.EventListener(ApplicationReadyEvent.class)
    public void init(){
        User user = new User();
        user.setId(1L);
        user.setFirstName("Jan");
        user.setLastName("Kowalski");
        user.setUsername("kowalski");
        user.setEmail("kowalski@gmail.com");
        user.setPassword("1234");
        user.setAddress("ul.Januszowa 5");
        user.setPostalCode("60-123");
        user.setCity("Poznan");
        user.setPhoneNumber(502676950L);
        userRepository.save(user);
    }
}
