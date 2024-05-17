package org.example.helloshoesbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SaleDTO {
    private String orderNo;
    private String orderItemQty;
    private double totalPrice;
    private String paymentMethod;
    private double addedPoints;
    private String cashierName;
}
