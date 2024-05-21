package org.example.helloshoesbackend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

    @ManyToOne
    private CustomerEntity customerEntity;

    @ManyToMany
    private List<InventoryEntity> sInventoryEntity;
}
