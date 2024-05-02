package org.example.helloshoesbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO implements SuperDTO{
    private String customerCode;
    private String customerName;
    private String customerDOB;
    private String customerGender;
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