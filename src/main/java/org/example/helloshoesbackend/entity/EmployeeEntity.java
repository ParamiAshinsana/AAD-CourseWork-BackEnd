package org.example.helloshoesbackend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "employee")
public class EmployeeEntity {
    @Id
    private String employeeCode;
    private String employeeName;
    @Column(columnDefinition = "LONGTEXT")
    private String employeeProfilePicture;

    @Temporal(TemporalType.DATE) // Optional if your database column is of type DATE
    private LocalDate employeeDob;

    @Enumerated(EnumType.STRING)
    private Gender employeeGender;
    private String employeeStatus;
    private String employeeDesignation;
    @Enumerated(EnumType.STRING)
    private AccessRole employeeAccessRole;

    @Temporal(TemporalType.DATE)
    private LocalDate employeeJoinedDate;

    private String attachedBranch;
    private String employeeAddress;
    private String employeeContact;
    private String employeeEmail;
    private String nameTheGuardian;
    private String emergencyContact;
}
