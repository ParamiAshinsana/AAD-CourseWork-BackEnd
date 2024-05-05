package org.example.helloshoesbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    private String supplierAddress01;
    private String supplierAddress02;
    private String supplierAddress03;
    private String supplierAddress04;
    private String supplierAddress05;
    private String supplierAddress06;
    private String contactNo01;
    private String contactNo02;
    private String supplierEmail;

    @OneToMany(mappedBy = "supplierEntity")
    private List<InventoryEntity> inventoryEntities ;
}
