package org.example.helloshoesbackend.repository;

import org.example.helloshoesbackend.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDAO extends JpaRepository<CustomerEntity, String> {
    @Query(value = "SELECT customerCode FROM Customer", nativeQuery = true)
    List<String> findCustomerCodes();

    @Query(value = "SELECT customerName FROM Customer WHERE customerCode = ?1", nativeQuery = true)
    String findCustomerNameById(String id);
}
