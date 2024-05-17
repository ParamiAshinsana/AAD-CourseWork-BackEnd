package org.example.helloshoesbackend.repository;

import org.example.helloshoesbackend.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryDAO extends JpaRepository<InventoryEntity, String> {
    @Query(value = "SELECT itemCode FROM Inventory", nativeQuery = true)
    List<String> findItemCodes();
}
