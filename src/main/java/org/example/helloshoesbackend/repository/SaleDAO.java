package org.example.helloshoesbackend.repository;

import org.example.helloshoesbackend.entity.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleDAO extends JpaRepository<SaleEntity, String> {
}
