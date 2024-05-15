package org.example.helloshoesbackend.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.helloshoesbackend.dto.EmployeeDTO;
import org.example.helloshoesbackend.dto.InventoryDTO;
import org.example.helloshoesbackend.entity.EmployeeEntity;
import org.example.helloshoesbackend.entity.InventoryEntity;
import org.example.helloshoesbackend.exception.NotFoundException;
import org.example.helloshoesbackend.repository.EmployeeDAO;
import org.example.helloshoesbackend.repository.InventoryDAO;
import org.example.helloshoesbackend.service.EmployeeService;
import org.example.helloshoesbackend.utill.EmployeeMapping;
import org.example.helloshoesbackend.utill.InventoryMapping;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeServiceIMPL implements EmployeeService {
    private final EmployeeDAO employeeDAO;
    private final EmployeeMapping employeeMapping;
    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = employeeMapping.toEmployee(employeeDTO);

        employeeEntity = employeeDAO.save(employeeEntity);
        return employeeMapping.toEmployeeDTO(employeeEntity);
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        return employeeMapping.toEmployeeDTOList(employeeDAO.findAll());
    }

    @Override
    public EmployeeDTO getSelectedEmployee(String id) {
        return null;
    }

    @Override
    public void deleteEmployee(String id) {
        if(!employeeDAO.existsById(id)) throw new NotFoundException("EmployeeController not found");
        employeeDAO.deleteById(id);
    }

    @Override
    public void updateEmployee(String id, EmployeeDTO employeeDTO) {

    }
}
