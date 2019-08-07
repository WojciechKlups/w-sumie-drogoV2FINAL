package pl.sda.wsumiedrogo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
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

    @NotEmpty(message = "Podaj nazwę produktu")
    private String name;
    @Min(value = 0, message = "Cena produktu nie może być mniejsza niż zero")
    private double price;

    private String description;
    private String manufacturer;
    private String category;

    @Min(value = 0, message = "Liczba sztuk produktu nie może być mniejsza niż zero")
    private int unitsInStock;
    private int weight;

    @Transient
    private MultipartFile image;


    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "products")
    private Set<Cart> carts;
}
