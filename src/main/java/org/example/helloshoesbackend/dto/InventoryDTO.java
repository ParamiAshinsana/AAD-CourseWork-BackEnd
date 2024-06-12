package org.example.helloshoesbackend.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InventoryDTO {
    private String itemCode;
    private String itemDescription;
    private String itemPicture;
    private String category;
    private int itemSize;
    private int itemQty;

    private SupplierDTO supplierEntity;
    private double unitPriceSale;
    private double unitPriceBuy;
    private double expectedProfit;
    private double profitMargin;


}
