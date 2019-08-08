package pl.sda.wsumiedrogo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;
    @NotNull
    private String code;
    @NotNull
    private double price;
    @NotNull
    private String brand;
    @NotNull
    private Category category;
    @NotNull
    private boolean onStock;
    @NotNull
    private int weight;
    @NotNull
    private int quantity;

    //
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "products")
    private Set<Cart> carts;
}