package pl.sda.wsumiedrogo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.wsumiedrogo.model.Product;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Long> {

    //TODO: zamienić query na Spring data z linku :
    // https://o7planning.org/en/10683/create-a-shopping-cart-web-application-with-spring-boot-hibernate
    // https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html

    Product findByName(String name);
}
