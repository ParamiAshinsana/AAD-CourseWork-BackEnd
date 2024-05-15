package org.example.helloshoesbackend.service;

import org.example.helloshoesbackend.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

    List<EmployeeDTO> getAllEmployee();
    EmployeeDTO getSelectedEmployee(String id);
    void deleteEmployee(String id);
    EmployeeDTO updateEmployee(String id, EmployeeDTO employeeDTO);
//    void updateEmployee(String id, EmployeeDTO employeeDTO);
}
