package pl.sda.wsumiedrogo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.sda.wsumiedrogo.model.Category;
import pl.sda.wsumiedrogo.model.Product;
import pl.sda.wsumiedrogo.model.User;
import pl.sda.wsumiedrogo.repositories.UserRepository;
@Configuration
public class EventListener {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public EventListener(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @org.springframework.context.event.EventListener(ApplicationReadyEvent.class)
    public void init(){

        Product maczek = new Product();
        maczek.setId(1L);
        maczek.setName("maczek");
        maczek.setCategory(Category.LAPTOPS);
        maczek.setPrice(999.00);
        maczek.setOnStock(true);
        maczek.setWeight(3);
        maczek.setQuantity(1);

        User user = new User();

        user.setUsername("kowalski");
        user.setFirstName("Jan");
        user.setLastName("Kowalski");
        user.setPhoneNumber(123_456_789L);
        user.setEmail("kowalski@gmail.com");
        user.setPassword(passwordEncoder.encode("1234"));
        user.setActivated(true);

        user.setAddress("Polanka 63");
        user.setCity("Poznań");
        user.setCountry("Poland");
        user.setZipCode("61-131");

        userRepository.save(user);
    }
}
