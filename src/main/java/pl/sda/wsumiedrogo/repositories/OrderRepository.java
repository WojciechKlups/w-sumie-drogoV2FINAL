//package pl.sda.wsumiedrogo.repositories;
//
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//import pl.sda.wsumiedrogo.model.Order;
//import pl.sda.wsumiedrogo.repositories.custom.OrderRepositoryCustom;
//
//@Repository
//public interface OrderRepository extends JpaRepository<Order,Long>, OrderRepositoryCustom {
//
//    //TODO: zamienić query na Spring data z linku :
//    // https://o7planning.org/en/10683/create-a-shopping-cart-web-application-with-spring-boot-hibernate
//    // https://www.baeldung.com/spring-data-jpa-query
//
//
//    Order findByOrderId(String orderId);
//
//    @Query("Select max(o.orderNumber) from  o ")
//    Order maxOrderNumber(@Param("name") String name );
//    Order.class.getName()
//
//
//}
