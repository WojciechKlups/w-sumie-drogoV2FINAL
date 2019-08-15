package pl.sda.wsumiedrogo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String username;
    private String firstName;
    private String lastName;
    private String image = "../img/user.png";
    private boolean isLoggedIn = false;
    @Column(unique = true)
    private Long phoneNumber;
    @Column(unique = true)
    private String email;
    private String password;
    private String activationCode;
    private boolean activated;

    private String address;
    private String city;
    private String country;
    private String zipCode;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_id",referencedColumnName = "id")
//    private Address address;


}