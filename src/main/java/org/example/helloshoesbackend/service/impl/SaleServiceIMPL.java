package org.example.helloshoesbackend.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.helloshoesbackend.dto.SaleDTO;
import org.example.helloshoesbackend.entity.CustomerEntity;
import org.example.helloshoesbackend.entity.SaleEntity;
import org.example.helloshoesbackend.repository.SaleDAO;
import org.example.helloshoesbackend.service.SaleService;
import org.example.helloshoesbackend.utill.SaleMapping;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class SaleServiceIMPL implements SaleService {

    private final SaleDAO saleDAO;
    private final SaleMapping saleMapping;

    @Override
    public SaleDTO saveSale(SaleDTO saleDTO) {
        SaleEntity saleEntity = saleMapping.toSale(saleDTO);

        saleEntity = saleDAO.save(saleEntity);
        return saleMapping.toSaleDTO(saleEntity);
    }
}
