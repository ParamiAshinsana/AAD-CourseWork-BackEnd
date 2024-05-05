package org.example.helloshoesbackend.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.helloshoesbackend.dto.CustomerDTO;
import org.example.helloshoesbackend.dto.InventoryDTO;
import org.example.helloshoesbackend.repository.CustomerDAO;
import org.example.helloshoesbackend.repository.InventoryDAO;
import org.example.helloshoesbackend.service.InventoryService;
import org.example.helloshoesbackend.utill.CustomerMapping;
import org.example.helloshoesbackend.utill.InventoryMapping;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class InventoryServiceIMPL implements InventoryService {
    private final InventoryDAO inventoryDAO;
    private final InventoryMapping inventoryMapping;

    @Override
    public List<InventoryDTO> getSuppliersCodes() {
        return inventoryMapping.toSupplierDTOList(inventoryDAO.findAll());
    }

}
