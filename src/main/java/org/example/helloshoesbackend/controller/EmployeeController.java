package org.example.helloshoesbackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.helloshoesbackend.dto.CustomerDTO;
import org.example.helloshoesbackend.dto.EmployeeDTO;
import org.example.helloshoesbackend.dto.InventoryDTO;
import org.example.helloshoesbackend.entity.Gender;
import org.example.helloshoesbackend.service.EmployeeService;
import org.example.helloshoesbackend.utilMatters.UtilMatters;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    EmployeeDTO employeeDTO = new EmployeeDTO();

    @PostMapping(value = "/saveEmployee")
    public EmployeeDTO saveEmployees(
            @RequestParam("empCode")String empCode,
            @RequestParam("empName")String empName,
            @RequestParam("files") MultipartFile files,
            @RequestParam("empDOB")String empDOB,
            @RequestParam("empGender")String empGender,
            @RequestParam("empStatus")String empStatus,
            @RequestParam("empDesignation")String empDesignation,
            @RequestParam("empAccessRole")String empAccessRole,
            @RequestParam("empJoinedDate")String empJoinedDate,
            @RequestParam("empBranch")String empBranch,
            @RequestParam("empAddress")String empAddress,
            @RequestParam("empContact")String empContact,
            @RequestParam("empEmail")String empEmail,
            @RequestParam("empGuardianNAme")String empGuardianNAme,
            @RequestParam("empEmergencyContact")String empEmergencyContact){
        String base64ProPic = UtilMatters.convertBase64(files);
        employeeDTO.setEmployeeCode(empCode);
        employeeDTO.setEmployeeName(empName);
        employeeDTO.setEmployeeProfilePicture(base64ProPic);
        employeeDTO.setEmployeeDob(LocalDate.parse(empDOB));
        employeeDTO.setEmployeeGender(Gender.valueOf(empGender));
        employeeDTO.setEmployeeStatus(empStatus);
        employeeDTO.setEmployeeDesignation(empDesignation);
        employeeDTO.setEmployeeAccessRole(empAccessRole);
        employeeDTO.setEmployeeJoinedDate(LocalDate.parse(empJoinedDate));
        employeeDTO.setAttachedBranch(empBranch);
        employeeDTO.setEmployeeAddress(empAddress);
        employeeDTO.setEmployeeContact(empContact);
        employeeDTO.setEmployeeEmail(empEmail);
        employeeDTO.setNameTheGuardian(empGuardianNAme);
        employeeDTO.setEmergencyContact(empEmergencyContact);

        return employeeService.saveEmployee(employeeDTO);

    }



    @PutMapping(value = "/updateEmployee/{empCode}")
    public EmployeeDTO updateEmployee(
            @RequestParam("empCode") String empCode,
            @RequestParam("empName") String empName,
            @RequestParam("files") MultipartFile files,
            @RequestParam("empDOB") String empDOB,
            @RequestParam("empGender") String empGender,
            @RequestParam("empStatus") String empStatus,
            @RequestParam("empDesignation") String empDesignation,
            @RequestParam("empAccessRole") String empAccessRole,
            @RequestParam("empJoinedDate") String empJoinedDate,
            @RequestParam("empBranch") String empBranch,
            @RequestParam("empAddress") String empAddress,
            @RequestParam("empContact") String empContact,
            @RequestParam("empEmail") String empEmail,
            @RequestParam("empGuardianNAme") String empGuardianNAme,
            @RequestParam("empEmergencyContact") String empEmergencyContact,
            @PathVariable("empCode") String emplCode) {

        // Convert the profile picture to Base64
        String base64ProPic = UtilMatters.convertBase64(files);

        // Create and populate the EmployeeDTO object
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmployeeCode(empCode);
        employeeDTO.setEmployeeName(empName);
        employeeDTO.setEmployeeProfilePicture(base64ProPic);
        employeeDTO.setEmployeeDob(LocalDate.parse(empDOB));
        employeeDTO.setEmployeeGender(Gender.valueOf(empGender));
        employeeDTO.setEmployeeStatus(empStatus);
        employeeDTO.setEmployeeDesignation(empDesignation);
        employeeDTO.setEmployeeAccessRole(empAccessRole);
        employeeDTO.setEmployeeJoinedDate(LocalDate.parse(empJoinedDate));
        employeeDTO.setAttachedBranch(empBranch);
        employeeDTO.setEmployeeAddress(empAddress);
        employeeDTO.setEmployeeContact(empContact);
        employeeDTO.setEmployeeEmail(empEmail);
        employeeDTO.setNameTheGuardian(empGuardianNAme);
        employeeDTO.setEmergencyContact(empEmergencyContact);

        // Call the service to update the employee
        return employeeService.updateEmployee(emplCode, employeeDTO);
    }

    @GetMapping(value = "/getAllEmployee")
    List<EmployeeDTO> getAllEmployees(){
        return employeeService.getAllEmployee();
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public void deleteEmployee(@PathVariable ("id") String id){
        employeeService.deleteEmployee(id);
    }
}
