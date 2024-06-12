package org.example.helloshoesbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
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
    private int orderItemQty;
    private double totalPrice;
    private LocalDate purchaseDate;
    private String paymentMethod;
    private double addedPoints;
    private String cashierName;

    @ManyToOne
    private CustomerEntity customerEntity;

    @ManyToOne
    private InventoryEntity inventoryEntities ;
}
