package org.example.helloshoesbackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.helloshoesbackend.dto.SaleDTO;
import org.example.helloshoesbackend.dto.SupplierDTO;
import org.example.helloshoesbackend.service.SaleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/sales")
@RequiredArgsConstructor
public class SaleController {

    private final SaleService saleService;

    @PostMapping(value = "/saveSale")
    public SaleDTO saveSales(@RequestBody SaleDTO saleDTO) {
        return saleService.saveSale(saleDTO);
    }

    @GetMapping(value = "/getAllSales")
    List<SaleDTO> getAllSale(){
        return saleService.getAllSales();
    }

    @DeleteMapping("/deleteSales/{id}")
    public void deleteSale(@PathVariable ("id") String id){
        saleService.deleteSales(id);
    }

}

