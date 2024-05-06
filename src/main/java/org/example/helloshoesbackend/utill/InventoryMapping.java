package org.example.helloshoesbackend.utill;

import lombok.RequiredArgsConstructor;
import org.example.helloshoesbackend.dto.CustomerDTO;
import org.example.helloshoesbackend.dto.InventoryDTO;
import org.example.helloshoesbackend.entity.CustomerEntity;
import org.example.helloshoesbackend.entity.InventoryEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InventoryMapping {
    private final ModelMapper modelMapper;

    public InventoryDTO toInventoryDTO(InventoryEntity inventoryEntity) {
        return  modelMapper.map(inventoryEntity, InventoryDTO.class);
    }
    public InventoryEntity toInventory(InventoryDTO inventoryDTO) {
        return  modelMapper.map(inventoryDTO, InventoryEntity.class);
    }
    public List<InventoryDTO> toInventoryDTOList(List<InventoryEntity> inventoryEntities) {
        return modelMapper.map(inventoryEntities, List.class);
    }
}
