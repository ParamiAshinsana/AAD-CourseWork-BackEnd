package org.example.helloshoesbackend.repository;

import org.example.helloshoesbackend.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDAO extends JpaRepository<EmployeeEntity, String> {
}
