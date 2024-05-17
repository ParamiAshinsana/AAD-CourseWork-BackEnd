package org.example.helloshoesbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "sale")
public class SaleEntity {
    @Id
    private String orderNo;
    private String orderItemQty;
    private double totalPrice;
    private String paymentMethod;
    private double addedPoints;
    private String cashierName;
}
