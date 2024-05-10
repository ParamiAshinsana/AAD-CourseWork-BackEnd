package org.example.helloshoesbackend.service;

import org.example.helloshoesbackend.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

    List<EmployeeDTO> getAllEmployee();
    EmployeeDTO getSelectedEmployee(String id);
    void deleteEmployee(String id);
    void updateEmployee(String id, EmployeeDTO employeeDTO);
}
