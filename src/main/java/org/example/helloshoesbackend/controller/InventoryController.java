package org.example.helloshoesbackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.helloshoesbackend.dto.CustomerDTO;
import org.example.helloshoesbackend.dto.InventoryDTO;
import org.example.helloshoesbackend.service.InventoryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

    @GetMapping(value = "/getAllSuppliersCodes")
    List<InventoryDTO> getAllSuppliers(){
        return inventoryService.getSuppliersCodes();
    }
}
