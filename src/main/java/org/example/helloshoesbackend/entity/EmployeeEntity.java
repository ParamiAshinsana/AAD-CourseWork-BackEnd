package org.example.helloshoesbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "employee")
public class EmployeeEntity {
    @Id
    private String employeeCode;
    private String employeeName;
    private String employeeProfilePicture;
    @Enumerated(EnumType.STRING)
    private Gender employeeGender;
    private String employeeStatus;
    private String employeeDesignation;
    @Enumerated(EnumType.STRING)
    private AccessRole employeeAccessRole;
    private Date employeeDob;
    private Date employeeJoinedDate;
    private String attachedBranch;
    private String employeeAddress;
    private String employeeContact;
    private String employeeEmail;
    private String nameTheGuardian;
    private String emergencyContact;
}
