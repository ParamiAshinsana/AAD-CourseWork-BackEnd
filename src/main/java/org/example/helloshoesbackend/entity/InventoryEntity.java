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
@Table(name = "inventory")
public class InventoryEntity {
    @Id
    private String itemCode;
    private String itemDescription;
    @Column(columnDefinition = "LONGTEXT")
    private String itemPicture;
    private String category;
    private int itemSize;
    private int itemQty;
//    private String supplierCode;
//    private String supplierName;
    private double unitPriceSale;
    private double unitPriceBuy;
    private double expectedProfit;
    private double profitMargin;

    @ManyToOne
    private SupplierEntity supplierEntity;

//    @ManyToMany(mappedBy = "sInventoryEntity" , fetch = FetchType.LAZY)
//    private List<SaleEntity> iSaleEntity;

    @OneToMany(mappedBy = "inventoryEntities" , fetch = FetchType.LAZY)
    @JsonIgnore
    private List<SaleEntity> saleEntity;

}
