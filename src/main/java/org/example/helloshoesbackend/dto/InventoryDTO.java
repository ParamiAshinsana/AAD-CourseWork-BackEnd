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
    private int itemQty;
    private int itemSize;
    private double unitPriceSale;
    private double unitPriceBuy;
    private double expectedProfit;
    private double profitMargin;
    private String status;

}
