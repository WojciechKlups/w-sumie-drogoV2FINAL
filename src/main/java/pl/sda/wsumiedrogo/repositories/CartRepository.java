package pl.sda.wsumiedrogo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.wsumiedrogo.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
