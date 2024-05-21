package org.example.helloshoesbackend.dto;

import lombok.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SaleDTO {
    private String orderNo;
    private CustomerDTO customerEntity;
    private List<InventoryDTO> sInventoryEntity;
    private String orderItemQty;
    private double totalPrice;
    private String paymentMethod;
    private double addedPoints;
    private String cashierName;
}
