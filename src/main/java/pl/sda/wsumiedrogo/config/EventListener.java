package pl.sda.wsumiedrogo.config;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import pl.sda.wsumiedrogo.model.Category;
import pl.sda.wsumiedrogo.model.Product;
import pl.sda.wsumiedrogo.model.User;
import pl.sda.wsumiedrogo.repositories.ProductRepository;
import pl.sda.wsumiedrogo.repositories.UserRepository;

import javax.jws.WebParam;

@Configuration
public class EventListener {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private ProductRepository productRepository;

    @Autowired
    public EventListener(UserRepository userRepository, PasswordEncoder passwordEncoder, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.productRepository = productRepository;
    }

    @org.springframework.context.event.EventListener(ApplicationReadyEvent.class)
    public void init() {

        Product maczek = new Product();

        maczek.setPrice(999.00);
        maczek.setBrand("Apple");
        maczek.setModel("Macbook Pro");
        maczek.setCategory(Category.LAPTOPS);
        maczek.setOnStock(true);
        maczek.setDescription("Lorem ipsum dolor sit amet, " +
                "consectetur adipisicing elit, sed do eiusmod tempor incididunt " +
                "ut labore et dolore magna aliqua. " +
                "Ut enim ad minim veniam, quis nostrud " +
                "exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
        maczek.setColor("Red");
        maczek.setSize("S");
        maczek.setQuantity(3);
        productRepository.save(maczek);

        Product lenovo = new Product();

        lenovo.setPrice(399.00);
        lenovo.setBrand("Lenovo");
        lenovo.setModel("NI WIM JAKIE");
        lenovo.setCategory(Category.LAPTOPS);
        lenovo.setOnStock(true);
        lenovo.setDescription("Lorem ipsum dolor sit amet, " +
                "consectetur adipisicing elit, sed do eiusmod tempor incididunt " +
                "ut labore et dolore magna aliqua. " +
                "Ut enim ad minim veniam, quis nostrud " +
                "exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
        lenovo.setColor("Red");
        lenovo.setSize("S");
        lenovo.setQuantity(3);
        productRepository.save(lenovo);

        Product huawei = new Product();

        huawei.setPrice(599.00);
        huawei.setBrand("Huiwei");
        huawei.setModel("WIM JOKI");
        huawei.setCategory(Category.LAPTOPS);
        huawei.setOnStock(true);
        huawei.setDescription("Lorem ipsum dolor sit amet, " +
                "consectetur adipisicing elit, sed do eiusmod tempor incididunt " +
                "ut labore et dolore magna aliqua. " +
                "Ut enim ad minim veniam, quis nostrud " +
                "exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
        huawei.setColor("Red");
        huawei.setSize("S");
        huawei.setQuantity(3);
        productRepository.save(huawei);

        Product msi = new Product();

        msi.setPrice(299.00);
        msi.setBrand("MSI");
        msi.setModel("Csi");
        msi.setCategory(Category.LAPTOPS);
        msi.setOnStock(true);
        msi.setDescription("Lorem ipsum dolor sit amet, " +
                "consectetur adipisicing elit, sed do eiusmod tempor incididunt " +
                "ut labore et dolore magna aliqua. " +
                "Ut enim ad minim veniam, quis nostrud " +
                "exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
        msi.setColor("Red");
        msi.setSize("S");
        msi.setQuantity(3);
        productRepository.save(msi);

        Product zus = new Product();

        zus.setPrice(3599.00);
        zus.setBrand("ZUS");
        zus.setModel("Suf");
        zus.setCategory(Category.LAPTOPS);
        zus.setOnStock(true);
        zus.setDescription("Lorem ipsum dolor sit amet, " +
                "consectetur adipisicing elit, sed do eiusmod tempor incididunt " +
                "ut labore et dolore magna aliqua. " +
                "Ut enim ad minim veniam, quis nostrud " +
                "exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
        zus.setColor("Red");
        zus.setSize("S");
        zus.setQuantity(3);
        productRepository.save(zus);

        Product nfz = new Product();

        nfz.setPrice(3599.00);
        nfz.setBrand("NFZ");
        nfz.setModel("Rmf-fm");
        nfz.setCategory(Category.LAPTOPS);
        nfz.setOnStock(true);
        nfz.setDescription("Lorem ipsum dolor sit amet, " +
                "consectetur adipisicing elit, sed do eiusmod tempor incididunt " +
                "ut labore et dolore magna aliqua. " +
                "Ut enim ad minim veniam, quis nostrud " +
                "exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
        nfz.setColor("Red");
        nfz.setSize("S");
        nfz.setQuantity(3);
        productRepository.save(nfz);

        Product pzpn = new Product();

        pzpn.setPrice(4599.00);
        pzpn.setBrand("PZPN");
        pzpn.setModel("2012");
        pzpn.setCategory(Category.LAPTOPS);
        pzpn.setOnStock(true);
        pzpn.setDescription("Lorem ipsum dolor sit amet, " +
                "consectetur adipisicing elit, sed do eiusmod tempor incididunt " +
                "ut labore et dolore magna aliqua. " +
                "Ut enim ad minim veniam, quis nostrud " +
                "exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
        pzpn.setColor("Red");
        pzpn.setSize("S");
        pzpn.setQuantity(3);
        productRepository.save(pzpn);

        Product santander = new Product();

        santander.setPrice(6599.00);
        santander.setBrand("Santantder");
        santander.setModel("Rzetelny Przyjazny Dla Ciebie Dla Rodziny");
        santander.setCategory(Category.LAPTOPS);
        santander.setOnStock(true);
        santander.setDescription("Lorem ipsum dolor sit amet, " +
                "consectetur adipisicing elit, sed do eiusmod tempor incididunt " +
                "ut labore et dolore magna aliqua. " +
                "Ut enim ad minim veniam, quis nostrud " +
                "exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
        santander.setColor("Red");
        santander.setSize("S");
        santander.setQuantity(3);
        productRepository.save(santander);

        Product pko = new Product();

        pko.setPrice(99.00);
        pko.setBrand("PKO");
        pko.setModel("Nie Dla Ciebie Ale Dla Rodziny");
        pko.setCategory(Category.LAPTOPS);
        pko.setOnStock(true);
        pko.setDescription("Lorem ipsum dolor sit amet, " +
                "consectetur adipisicing elit, sed do eiusmod tempor incididunt " +
                "ut labore et dolore magna aliqua. " +
                "Ut enim ad minim veniam, quis nostrud " +
                "exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
        pko.setColor("Red");
        pko.setSize("S");
        pko.setQuantity(3);
        productRepository.save(pko);


        Product pkp = new Product();

        pkp.setPrice(9999.00);
        pkp.setBrand("PKP");
        pkp.setModel("JADOM SWIRY JADOM");
        pkp.setCategory(Category.LAPTOPS);
        pkp.setOnStock(true);
        pkp.setDescription("Lorem ipsum dolor sit amet, " +
                "consectetur adipisicing elit, sed do eiusmod tempor incididunt " +
                "ut labore et dolore magna aliqua. " +
                "Ut enim ad minim veniam, quis nostrud " +
                "exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
        pkp.setColor("Red");
        pkp.setSize("S");
        pkp.setQuantity(3);
        productRepository.save(pkp);
        // maczek.setAvailability(Availability.AVAILABILITY_ONSTOCK.getRole());

        //________________________________________________________________________________________
        User user = new User();
        User userNowak = new User();

        user.setId(1L);
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

        userNowak.setId(2L);
        userNowak.setUsername("Nowak");
        userNowak.setFirstName("Jan");
        userNowak.setLastName("Nowak");
        userNowak.setPhoneNumber(987_654_321L);
        userNowak.setEmail("nowak@gmail.com");
        userNowak.setPassword(passwordEncoder.encode("4321"));
        userNowak.setActivated(true);
        userNowak.setRole("ADMIN");

        userNowak.setAddress("Polanka 63");
        userNowak.setCity("Poznań");
        userNowak.setCountry("Poland");
        userNowak.setZipCode("61-131");


        userRepository.save(user);
        userRepository.save(userNowak);

    }
}
