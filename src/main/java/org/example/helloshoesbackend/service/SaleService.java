package org.example.helloshoesbackend.service;

import org.example.helloshoesbackend.dto.InventoryDTO;
import org.example.helloshoesbackend.dto.ItemDetailsDTO;
import org.example.helloshoesbackend.dto.SaleDTO;

import java.util.List;

public interface SaleService {
    SaleDTO saveSale(SaleDTO saleDTO);

    List<SaleDTO> getAllSales();

    void deleteSales(String id);

//    Double getTotalSaleItem(String date);
//
//    Double getTotalProfit(String date);

    ItemDetailsDTO getBestSellingInventory(String date);
}
