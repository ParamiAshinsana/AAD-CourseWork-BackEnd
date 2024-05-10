package org.example.helloshoesbackend.utill;

import lombok.RequiredArgsConstructor;
import org.example.helloshoesbackend.dto.EmployeeDTO;
import org.example.helloshoesbackend.entity.EmployeeEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EmployeeMapping {
    private final ModelMapper mapper;

    public EmployeeDTO toEmployeeDTO(EmployeeEntity employeeEntity) {
        return  mapper.map(employeeEntity, EmployeeDTO.class);
    }
    public EmployeeEntity toEmployee(EmployeeDTO employeeDTO) {
        return  mapper.map(employeeDTO, EmployeeEntity.class);
    }
    public List<EmployeeDTO> toEmployeeDTOList(List<EmployeeEntity> employeeEntities) {
        return mapper.map(employeeEntities, List.class);
    }
}
