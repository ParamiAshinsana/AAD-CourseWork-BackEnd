package org.example.helloshoesbackend.repository;

import org.example.helloshoesbackend.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierDAO extends JpaRepository<SupplierEntity, String> {
    @Query(value = "SELECT supplierName FROM Supplier WHERE supplierCode = ?1", nativeQuery = true)
    String findNameById(String id);

    @Query(value = "SELECT supplierCode FROM Supplier", nativeQuery = true)
    List<String> findSupplierCodes();
}
