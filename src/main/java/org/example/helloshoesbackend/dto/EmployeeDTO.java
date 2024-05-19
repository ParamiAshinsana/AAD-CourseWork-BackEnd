package org.example.helloshoesbackend.dto;

import lombok.*;
import org.example.helloshoesbackend.entity.Gender;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeDTO {
    private String employeeCode;
    private String employeeName;
    private String employeeProfilePicture;
    private LocalDate employeeDob;
    private Gender employeeGender;
    private String employeeStatus;
    private String employeeDesignation;
    private String employeeAccessRole;
    private LocalDate employeeJoinedDate;
    private String attachedBranch;
    private String employeeAddress;
    private String employeeContact;
    private String employeeEmail;
    private String nameTheGuardian;
    private String emergencyContact;

}
