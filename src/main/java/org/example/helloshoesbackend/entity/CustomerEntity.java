package org.example.helloshoesbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "customer")
public class CustomerEntity {
    @Id
    private String customerCode;
    private String customerName;
    private String customerDOB;
//    @Enumerated(EnumType.ORDINAL)
    @Enumerated(EnumType.STRING)
    private Gender customerGender;
    private String customerJoinDate;
    private int customerLoyaltyPoints;
    private String loyaltyLevel;
    private String customerAddress;
//    private String customerAddress01;
//    private String customerAddress02;
//    private String customerAddress03;
//    private String customerAddress04;
//    private String customerAddress05;
    private String customerContact;
    private String customerEmail;
}