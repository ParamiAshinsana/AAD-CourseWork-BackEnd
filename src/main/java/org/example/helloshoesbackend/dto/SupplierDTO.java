package org.example.helloshoesbackend.dto;

import lombok.*;
import org.example.helloshoesbackend.entity.Category;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SupplierDTO implements SuperDTO{
    private String supplierCode;
    private String supplierName;
    private Category category;
    private String supplierAddress01;
    private String supplierAddress02;
    private String supplierAddress03;
    private String supplierAddress04;
    private String supplierAddress05;
    private String supplierAddress06;
    private String contactNo01;
    private String contactNo02;
    private String supplierEmail;
}