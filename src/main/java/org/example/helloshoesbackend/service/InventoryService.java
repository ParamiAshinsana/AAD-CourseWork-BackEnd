package org.example.helloshoesbackend.service;

import org.example.helloshoesbackend.dto.InventoryDTO;
import org.example.helloshoesbackend.entity.InventoryEntity;

import java.util.List;

public interface InventoryService {
    InventoryDTO saveInventory(InventoryDTO inventoryDTO);

    List<InventoryDTO> getAllInventory();

    void deleteInventory(String id);

    List<String> getAllItemCodes();

    List<InventoryDTO> getInventoryDescription(String id);

    String getInventoryPrices(String id);

    String getShoeSizes(String id);
}
