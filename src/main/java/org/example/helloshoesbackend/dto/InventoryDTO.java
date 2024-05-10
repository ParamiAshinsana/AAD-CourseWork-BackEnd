package org.example.helloshoesbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InventoryDTO {
    private String itemCode;
    private String itemDescription;
    private String itemPicture;
    private String category;
    private int itemSize;
    private int itemQty;
//    private String supplierCode;
//    private String supplierName;
    private String supplierEntity;
    private double unitPriceSale;
    private double unitPriceBuy;
    private double expectedProfit;
    private double profitMargin;


}
