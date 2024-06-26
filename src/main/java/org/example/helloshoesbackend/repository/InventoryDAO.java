package org.example.helloshoesbackend.repository;

import org.example.helloshoesbackend.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryDAO extends JpaRepository<InventoryEntity, String> {
    @Query(value = "SELECT itemCode FROM Inventory", nativeQuery = true)
    List<String> findItemCodes();

    @Query(value = "SELECT * FROM Inventory WHERE itemCode = ?1", nativeQuery = true)
//    @Query(value = "SELECT itemDescription FROM Inventory WHERE itemCode = ?1", nativeQuery = true)
    List<InventoryEntity> findInventoryDescriptionById(String id);


    @Query(value = "SELECT unitPriceSale FROM Inventory WHERE itemCode = ?1", nativeQuery = true)
    String findInventoryPricessById(String id);

    @Query(value = "SELECT itemSize FROM Inventory WHERE itemCode = ?1", nativeQuery = true)
    String findShoeSizeById(String id);

    InventoryEntity findByItemCode(String itemCode);


    @Modifying
    @Query("UPDATE InventoryEntity i SET i.itemQty = i.itemQty - :orderItemQty WHERE i.itemCode = :itemCode AND i.itemQty >= :orderItemQty")
    int decrementItemQty(@Param("itemCode") String itemCode, @Param("orderItemQty") int orderItemQty);
}
