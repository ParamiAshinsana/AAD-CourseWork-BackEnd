package org.example.helloshoesbackend.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.helloshoesbackend.dto.InventoryDTO;
import org.example.helloshoesbackend.entity.AccessRole;
import org.example.helloshoesbackend.entity.EmployeeEntity;
import org.example.helloshoesbackend.entity.InventoryEntity;
import org.example.helloshoesbackend.exception.NotFoundException;
import org.example.helloshoesbackend.repository.InventoryDAO;
import org.example.helloshoesbackend.service.InventoryService;
import org.example.helloshoesbackend.utill.InventoryMapping;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class InventoryServiceIMPL implements InventoryService {
    private final InventoryDAO inventoryDAO;
    private final InventoryMapping inventoryMapping;


    @Override
    public InventoryDTO saveInventory(InventoryDTO inventoryDTO) {
        InventoryEntity inventoryEntity = inventoryMapping.toInventory(inventoryDTO);

        inventoryEntity = inventoryDAO.save(inventoryEntity);
        return inventoryMapping.toInventoryDTO(inventoryEntity);
    }

    @Override
    public List<InventoryDTO> getAllInventory() {
        System.out.println("get IMPL");
        System.out.println(inventoryDAO);
        return inventoryMapping.toInventoryDTOList(inventoryDAO.findAll());
    }

    @Override
    public void deleteInventory(String id) {
        if(!inventoryDAO.existsById(id)) throw new NotFoundException("Inventory not found");
        inventoryDAO.deleteById(id);
    }


    // To Sale Service Controller
    @Override
    public List<String> getAllItemCodes() {
        return inventoryDAO.findItemCodes();
    }

    @Override
    public List<InventoryDTO> getInventoryDescription(String id) {
//        String id = "szfgz";
        if(!inventoryDAO.existsById(id)) throw new NotFoundException("Inventory not found");

        return inventoryMapping.toInventoryDTOList(inventoryDAO.findInventoryDescriptionById(id));
    }

    @Override
    public String getInventoryPrices(String id) {
        if(!inventoryDAO.existsById(id)) throw new NotFoundException("Inventory not found");
        return inventoryDAO.findInventoryPricessById(id);
    }

    @Override
    public String getShoeSizes(String id) {
        if(!inventoryDAO.existsById(id)) throw new NotFoundException("Inventory not found");
        return inventoryDAO.findShoeSizeById(id);
    }

    @Override
    public InventoryDTO updateInventory(String iCode, InventoryDTO inventoryDTO) {
        Optional<InventoryEntity> tmpInventory = inventoryDAO.findById(iCode);
        if (!tmpInventory.isPresent()) {
            throw new NotFoundException("Inventory not found with code: " + iCode);
        }

        // Update the employee details
        tmpInventory.get().setItemDescription(inventoryDTO.getItemDescription());
        tmpInventory.get().setItemPicture(inventoryDTO.getItemPicture());
        tmpInventory.get().setCategory(inventoryDTO.getCategory());
        tmpInventory.get().setItemSize(inventoryDTO.getItemSize());
        tmpInventory.get().setItemQty(inventoryDTO.getItemQty());
        tmpInventory.get().setUnitPriceSale(inventoryDTO.getUnitPriceSale());
        tmpInventory.get().setUnitPriceBuy(inventoryDTO.getUnitPriceBuy());
        tmpInventory.get().setExpectedProfit(inventoryDTO.getExpectedProfit());
        tmpInventory.get().setProfitMargin(inventoryDTO.getProfitMargin());


        return inventoryMapping.toInventoryDTO(tmpInventory.get());
    }
}
