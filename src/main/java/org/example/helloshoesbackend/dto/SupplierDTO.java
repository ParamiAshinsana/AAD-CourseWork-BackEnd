package org.example.helloshoesbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.helloshoesbackend.entity.Category;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SupplierDTO implements SuperDTO{
    private String supplierCode;
    private String supplierName;
    private Category category;
    private String customerAddress01;
    private String customerAddress02;
    private String customerAddress03;
    private String customerAddress04;
    private String customerAddress05;
    private String customerAddress06;
    private String ContactNo01;
    private String ContactNo02;
    private String supplierEmail;
}
