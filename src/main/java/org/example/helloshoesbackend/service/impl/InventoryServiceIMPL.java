package org.example.helloshoesbackend.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.helloshoesbackend.dto.InventoryDTO;
import org.example.helloshoesbackend.service.InventoryService;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class InventoryServiceIMPL implements InventoryService {
    @Override
    public InventoryDTO getSuppliersCodes(InventoryDTO inventoryDTO) {
        return null;
    }
}
