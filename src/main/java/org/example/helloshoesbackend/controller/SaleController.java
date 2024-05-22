package org.example.helloshoesbackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.helloshoesbackend.dto.CustomerDTO;
import org.example.helloshoesbackend.dto.InventoryDTO;
import org.example.helloshoesbackend.dto.SaleDTO;
import org.example.helloshoesbackend.dto.SupplierDTO;
import org.example.helloshoesbackend.service.SaleService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/sales")
@RequiredArgsConstructor
public class SaleController {

    private final SaleService saleService;
    SaleDTO salesDTO = new SaleDTO();

    @PostMapping(value = "/saveSale")
    public SaleDTO saveSales(@RequestBody SaleDTO saleDTO) {
        return saleService.saveSale(saleDTO);
    }

//    @PostMapping(value = "/saveSale")
//    public SaleDTO saveSales(@RequestBody SaleDTO saleDTO){
//
//        CustomerDTO customerDTO = new CustomerDTO();
//        customerDTO.setCustomerCode(String.valueOf(customerDTO));
//        salesDTO.setCusDTO(customerDTO);
//
//        InventoryDTO inventoryDTO = new InventoryDTO();
//        inventoryDTO.setItemCode(String.valueOf(inventoryDTO));
//        salesDTO.setInvDTO(inventoryDTO);
//
//        return saleService.saveSale(saleDTO);
//    }


//    @PostMapping(value = "/saveSale")
//    public SaleDTO saveSales(@RequestBody SaleDTO saleDTO, @RequestParam String cusID, @RequestParam String invId) {
//        CustomerDTO customerDTO = new CustomerDTO();
//        customerDTO.setCustomerCode(cusID);
//        saleDTO.setCusDTO(customerDTO);
//
//        InventoryDTO inventoryDTO = new InventoryDTO();
//        inventoryDTO.setItemCode(invId);
//        saleDTO.setInvDTO(inventoryDTO);
//
//        return saleService.saveSale(saleDTO);
//    }
}

