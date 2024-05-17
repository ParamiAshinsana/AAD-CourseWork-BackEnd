package org.example.helloshoesbackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.helloshoesbackend.dto.CustomerDTO;
import org.example.helloshoesbackend.dto.SaleDTO;
import org.example.helloshoesbackend.service.SaleService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/sales")
@RequiredArgsConstructor
public class SaleController {

    private final SaleService saleService;

    @PostMapping(value = "/saveSale")
    public SaleDTO saveSales(@RequestBody SaleDTO saleDTO){
        return saleService.saveSale(saleDTO);
    }
}
