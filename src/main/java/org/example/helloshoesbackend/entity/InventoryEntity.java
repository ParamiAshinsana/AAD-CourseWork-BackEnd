package org.example.helloshoesbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "inventory")
public class InventoryEntity {
    @Id
    private String itemCode;
    private String itemDescription;
    @Column(columnDefinition = "LONGTEXT")
    private String itemPicture;
    private String category;
    private int itemQty;
    private int itemSize;
    private double unitPriceSale;
    private double unitPriceBuy;
    private double expectedProfit;
    private double profitMargin;

    @ManyToOne
    private SupplierEntity supplierEntity;
}
