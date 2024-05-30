package org.example.helloshoesbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "systemuser")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
}
