package org.example.helloshoesbackend.utill;

import lombok.RequiredArgsConstructor;
import org.example.helloshoesbackend.dto.SupplierDTO;
import org.example.helloshoesbackend.entity.SupplierEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SupplierMapping {
    private final ModelMapper mapper;

    public SupplierDTO toSupplierDTO(SupplierEntity supplierEntity) {
        return  mapper.map(supplierEntity, SupplierDTO.class);
    }
    public SupplierEntity toSupplier(SupplierDTO supplierDTO) {
        return  mapper.map(supplierDTO, SupplierEntity.class);
    }
    public List<SupplierDTO> toSupplierDTOList(List<SupplierEntity> supplierEntities) {
        return mapper.map(supplierEntities, List.class);
    }
}
