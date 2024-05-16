package org.example.helloshoesbackend.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.helloshoesbackend.dto.EmployeeDTO;
import org.example.helloshoesbackend.entity.AccessRole;
import org.example.helloshoesbackend.entity.CustomerEntity;
import org.example.helloshoesbackend.entity.EmployeeEntity;
import org.example.helloshoesbackend.exception.NotFoundException;
import org.example.helloshoesbackend.repository.EmployeeDAO;
import org.example.helloshoesbackend.service.EmployeeService;
import org.example.helloshoesbackend.utilMatters.UtilMatters;
import org.example.helloshoesbackend.utill.EmployeeMapping;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public EmployeeDTO updateEmployee(String id, EmployeeDTO employeeDTO) {
        Optional<EmployeeEntity> tmpEmployee = employeeDAO.findById(id);
        if (!tmpEmployee.isPresent()) {
            throw new NotFoundException("Employee not found with code: " + id);
        }

        // Update the employee details
        tmpEmployee.get().setEmployeeName(employeeDTO.getEmployeeName());
        tmpEmployee.get().setEmployeeProfilePicture(employeeDTO.getEmployeeProfilePicture());
        tmpEmployee.get().setEmployeeDob(employeeDTO.getEmployeeDob());
        tmpEmployee.get().setEmployeeGender(employeeDTO.getEmployeeGender());
        tmpEmployee.get().setEmployeeStatus(employeeDTO.getEmployeeStatus());
        tmpEmployee.get().setEmployeeDesignation(employeeDTO.getEmployeeDesignation());
        tmpEmployee.get().setEmployeeAccessRole(AccessRole.valueOf(employeeDTO.getEmployeeAccessRole()));
        tmpEmployee.get().setEmployeeJoinedDate(employeeDTO.getEmployeeJoinedDate());
        tmpEmployee.get().setAttachedBranch(employeeDTO.getAttachedBranch());
        tmpEmployee.get().setEmployeeAddress(employeeDTO.getEmployeeAddress());
        tmpEmployee.get().setEmployeeContact(employeeDTO.getEmployeeContact());
        tmpEmployee.get().setEmployeeEmail(employeeDTO.getEmployeeEmail());
        tmpEmployee.get().setNameTheGuardian(employeeDTO.getNameTheGuardian());
        tmpEmployee.get().setEmergencyContact(employeeDTO.getEmergencyContact());

        return employeeMapping.toEmployeeDTO(tmpEmployee.get());

    }
}
