//package pl.sda.wsumiedrogo.model;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Builder
//@Table(name = "address")
//public class Address {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long id;
//    private String streetName;
//    private String apartmentNumber;
//    private String city;
//    private String country;
//    private String zipCode;
//
//    @OneToOne(mappedBy = "address")
//    private User user;
//
//}
