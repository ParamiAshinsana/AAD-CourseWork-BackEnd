package org.example.helloshoesbackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.helloshoesbackend.dto.ItemDetailsDTO;
import org.example.helloshoesbackend.dto.SaleDTO;
import org.example.helloshoesbackend.service.SaleService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/sales")
@RequiredArgsConstructor
public class SaleController {

    private final SaleService saleService;

    @PostMapping(value = "/saveSale")
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    public SaleDTO saveSales(@RequestBody SaleDTO saleDTO) {
        return saleService.saveSale(saleDTO);
    }

    @GetMapping(value = "/getAllSales")
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    List<SaleDTO> getAllSale(){
        return saleService.getAllSales();
    }

    @DeleteMapping("/deleteSales/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteSale(@PathVariable ("id") String id){
        saleService.deleteSales(id);
    }

    // Only Admin Control

//    @GetMapping("/getTotalSale/{date}")
//    public Double getTotalSaleItemm(@PathVariable String date){
//        return saleService.getTotalSaleItem(date);
//    }
//
//    @GetMapping("/getTotalProfit/{date}")
//    public Double getTotalProfit(@PathVariable String date){
//        return saleService.getTotalProfit(date);
//    }

    @GetMapping("/getBestSellingInventory/{date}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ItemDetailsDTO getBestSellingInventory(@PathVariable String date) {
        return saleService.getBestSellingInventory(date);
    }

}

