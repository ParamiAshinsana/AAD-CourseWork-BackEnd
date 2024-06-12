package org.example.helloshoesbackend.repository;

import org.example.helloshoesbackend.entity.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SaleDAO extends JpaRepository<SaleEntity, String> {
    @Query("SELECT s.inventoryEntities.itemCode, s.inventoryEntities.itemDescription, SUM(s.orderItemQty) AS totalQty " +
            "FROM SaleEntity s WHERE s.purchaseDate = :date " +
            "GROUP BY s.inventoryEntities.itemCode, s.inventoryEntities.itemDescription " +
            "ORDER BY totalQty DESC")
    List<Object[]> findBestSellingInventory(@Param("date") LocalDate date);
}
