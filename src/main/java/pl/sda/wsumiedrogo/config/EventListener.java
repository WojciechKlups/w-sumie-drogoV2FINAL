package pl.sda.wsumiedrogo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.parameters.P;
import pl.sda.wsumiedrogo.model.*;
import pl.sda.wsumiedrogo.repositories.ProductsRepository;
import pl.sda.wsumiedrogo.repositories.UserRepository;
@Configuration
public class EventListener {

    private UserRepository userRepository;
    private ProductsRepository productsRepository;

    @Autowired
    public EventListener(UserRepository userRepository, ProductsRepository productsRepository) {
        this.userRepository = userRepository;
        this.productsRepository = productsRepository;
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
        productsRepository.save(maczek);

        User user = new User();
        Cart cart = new Cart();

        user.setId(1L);
        user.setFirstName("Jan");
        user.setLastName("Kowalski");
        user.setUsername("kowalski");
        user.setEmail("kowalski@gmail.com");
        user.setPassword("1234");
        // user.setAddress("ul.Januszowa 5");
        user.setPostalCode("60-123");
        user.setCity("Poznan");
        user.setRoles("USER");
        user.setPhoneNumber(502676950L);
        user.setActivated(true);
        user.setCart(cart);
        userRepository.save(user);
    }
}
