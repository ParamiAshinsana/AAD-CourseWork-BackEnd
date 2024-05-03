package org.example.helloshoesbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "supplier")
public class SupplierEntity {
    @Id
    private String supplierCode;
    private String supplierName;
    @Enumerated(EnumType.STRING)
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
