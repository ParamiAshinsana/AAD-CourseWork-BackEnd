package org.example.helloshoesbackend.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.helloshoesbackend.dto.SaleDTO;
import org.example.helloshoesbackend.service.InventoryService;
import org.example.helloshoesbackend.service.SaleService;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class SaleServiceIMPL implements SaleService {

    @Override
    public SaleDTO saveSale(SaleDTO saleDTO) {
        return null;
    }
}
