package org.example.helloshoesbackend.service;

import org.example.helloshoesbackend.dto.InventoryDTO;

import java.util.List;

public interface InventoryService {

    List<InventoryDTO> getSuppliersCodes();
}
