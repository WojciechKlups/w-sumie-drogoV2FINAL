package pl.sda.wsumiedrogo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.sda.wsumiedrogo.model.Availability;
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


        Product product = new Product();

        product.setPrice(999.00);
        product.setBrand("Apple");
        product.setModel("Macbook Pro");
        product.setCategory(Category.LAPTOPS);
        product.setOnStock(true);
        product.setAvailability(Availability.AVAILABILITY_ONSTOCK.getRole());

        User user = new User();
        User userNowak = new User();

        user.setUsername("kowalski");
        user.setFirstName("Jan");
        user.setLastName("Kowalski");
        user.setPhoneNumber(123_456_789L);
        user.setEmail("kowalski@gmail.com");
        user.setPassword(passwordEncoder.encode("1234"));
        user.setActivated(true);
        user.setRole("USER");

        user.setAddress("Polanka 63");
        user.setCity("Poznań");
        user.setCountry("Poland");
        user.setZipCode("61-131");
//_____________________________________________
        userNowak.setUsername("kowalski");
        userNowak.setFirstName("Jan");
        userNowak.setLastName("Kowalski");
        userNowak.setPhoneNumber(123_456_789L);
        userNowak.setEmail("kowalski@gmail.com");
        userNowak.setPassword(passwordEncoder.encode("1234"));
        userNowak.setActivated(true);
        userNowak.setRole("ADMIN");

        userNowak.setAddress("Polanka 63");
        userNowak.setCity("Poznań");
        userNowak.setCountry("Poland");
        userNowak.setZipCode("61-131");


        userRepository.save(user);
    }
}
