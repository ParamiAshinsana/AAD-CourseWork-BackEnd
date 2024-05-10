package org.example.helloshoesbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.helloshoesbackend.entity.Gender;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDTO {
    private String employeeCode;
    private String employeeName;
    private String employeeProfilePicture;
    private Gender employeeGender;
    private String employeeStatus;
    private String employeeDesignation;
    private String employeeAccessRole;
    private Date employeeDob;
    private Date employeeJoinedDate;
    private String attachedBranch;
    private String employeeAddress;
    private String employeeContact;
    private String employeeEmail;
    private String nameTheGuardian;
    private String emergencyContact;

}
