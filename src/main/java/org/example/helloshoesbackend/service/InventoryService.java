package org.example.helloshoesbackend.service;

import org.example.helloshoesbackend.dto.InventoryDTO;
import org.example.helloshoesbackend.entity.SupplierEntity;

import java.util.List;

public interface InventoryService {


    InventoryDTO saveInventory(InventoryDTO inventoryDTO);
}
