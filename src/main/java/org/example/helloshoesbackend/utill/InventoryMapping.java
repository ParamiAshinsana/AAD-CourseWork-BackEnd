package org.example.helloshoesbackend.utill;

import lombok.RequiredArgsConstructor;
import org.example.helloshoesbackend.dto.InventoryDTO;
import org.example.helloshoesbackend.entity.InventoryEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InventoryMapping {
    private final ModelMapper mapper;
    public List<InventoryDTO> toSupplierDTOList(List<InventoryEntity> inventoryEntities) {
        return mapper.map(inventoryEntities, List.class);
    }
}
