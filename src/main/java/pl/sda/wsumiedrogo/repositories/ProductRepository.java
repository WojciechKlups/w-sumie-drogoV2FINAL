package pl.sda.wsumiedrogo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.wsumiedrogo.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findByModelAndBrand(String model,String brand);
}
