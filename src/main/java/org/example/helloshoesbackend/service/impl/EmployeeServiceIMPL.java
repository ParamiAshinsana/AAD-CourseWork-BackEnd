package org.example.helloshoesbackend.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.helloshoesbackend.dto.EmployeeDTO;
import org.example.helloshoesbackend.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeServiceIMPL implements EmployeeService {
    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        return null;
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        return null;
    }

    @Override
    public EmployeeDTO getSelectedEmployee(String id) {
        return null;
    }

    @Override
    public void deleteEmployee(String id) {

    }

    @Override
    public void updateEmployee(String id, EmployeeDTO employeeDTO) {

    }
}
