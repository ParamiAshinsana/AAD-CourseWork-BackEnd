package org.example.helloshoesbackend.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SaleDTO {
    private String orderNo;
    private String orderItemQty;
    private double totalPrice;
    private String paymentMethod;
    private double addedPoints;
    private String cashierName;
}
