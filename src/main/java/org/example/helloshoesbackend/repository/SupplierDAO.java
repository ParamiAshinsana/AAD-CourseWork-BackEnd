package org.example.helloshoesbackend.repository;

import org.example.helloshoesbackend.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierDAO extends JpaRepository<SupplierEntity, String> {
}
