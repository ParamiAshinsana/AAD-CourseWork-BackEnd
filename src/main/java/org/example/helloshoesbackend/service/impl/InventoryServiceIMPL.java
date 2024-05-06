package org.example.helloshoesbackend.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.helloshoesbackend.dto.InventoryDTO;
import org.example.helloshoesbackend.entity.CustomerEntity;
import org.example.helloshoesbackend.entity.InventoryEntity;
import org.example.helloshoesbackend.entity.SupplierEntity;
import org.example.helloshoesbackend.repository.InventoryDAO;
import org.example.helloshoesbackend.service.InventoryService;
import org.example.helloshoesbackend.utill.InventoryMapping;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class InventoryServiceIMPL implements InventoryService {
    private final InventoryDAO inventoryDAO;
    private final InventoryMapping inventoryMapping;



}
