package org.example.helloshoesbackend.dto;

import lombok.*;
import org.example.helloshoesbackend.entity.Gender;
import org.example.helloshoesbackend.entity.Level;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerDTO implements SuperDTO{
    private String customerCode;
    private String customerName;
    private String customerDOB;
    private Gender customerGender;
    private String customerJoinDate;
    private int customerLoyaltyPoints;
    private Level loyaltyLevel;
    private String customerAddress;

    private String customerContact;
    private String customerEmail;
}