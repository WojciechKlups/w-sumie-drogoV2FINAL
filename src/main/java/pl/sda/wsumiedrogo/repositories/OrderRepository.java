package pl.sda.wsumiedrogo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.wsumiedrogo.model.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {

    //TODO: zamienić query na Spring data z linku :
    // https://o7planning.org/en/10683/create-a-shopping-cart-web-application-with-spring-boot-hibernate


}
