package org.example.helloshoesbackend.entity;

import jakarta.persistence.*;
import lombok.*;

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

}
