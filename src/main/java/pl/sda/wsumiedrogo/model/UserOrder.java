package pl.sda.wsumiedrogo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class UserOrder {
    @Id
    @GeneratedValue
    private long customerOrderId;


    @ManyToOne
    @JoinColumn(name = "cartId")
    private Cart cart;

    @OneToOne
    private Address address;

    private String customerName;
    private Date date;
    private boolean paid;
    private boolean sent;
    private boolean confirmed;


}
