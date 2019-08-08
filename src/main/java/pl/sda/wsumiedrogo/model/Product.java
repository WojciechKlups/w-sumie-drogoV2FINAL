package pl.sda.wsumiedrogo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private double price;
    private String brand;
    private Category category;
    private boolean onStock;
    private int weight;
    private int quantity;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "products")
    private Set<Cart> carts;
}