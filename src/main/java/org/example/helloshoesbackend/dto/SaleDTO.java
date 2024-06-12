package org.example.helloshoesbackend.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SaleDTO {
    private String orderNo;
    private CustomerDTO cusDTO;
    private InventoryDTO invDTO;
    private int orderItemQty;
    private double totalPrice;
    private LocalDate purchaseDate;
    private String paymentMethod;
    private double addedPoints;
    private String cashierName;
}
