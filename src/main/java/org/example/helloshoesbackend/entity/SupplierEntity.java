package org.example.helloshoesbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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


    @OneToMany(mappedBy = "supplierEntity" , fetch = FetchType.LAZY)
    @JsonIgnore
    private List<InventoryEntity> inventoryEntities ;
}
