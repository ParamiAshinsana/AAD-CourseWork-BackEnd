package org.example.helloshoesbackend.repository;


import org.example.helloshoesbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
