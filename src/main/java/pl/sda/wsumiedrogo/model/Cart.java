package pl.sda.wsumiedrogo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cart {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    //TODO: Sprawdź jaką bibliotekę do czasu użyć

    private LocalDateTime orderDateTime;
    private int cartNumber;
    private double amount;
    private String userName;
    private String userAddress;
    private String userEmail;
    private String userPhone;
}
