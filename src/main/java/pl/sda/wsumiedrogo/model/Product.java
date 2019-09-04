package pl.sda.wsumiedrogo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String model;
    private String brand;
    private double price;
    private Category category;
    private int quantity;
    private String description;
    private byte[] image;
    private String color;
    private String size;

    private boolean onStock;

    //TODO: trzeba by dorobić klasę detailsową produktów
//    private int weight;
//

}