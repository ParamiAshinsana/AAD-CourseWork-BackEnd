package org.example.helloshoesbackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.helloshoesbackend.dto.SupplierDTO;
import org.example.helloshoesbackend.service.SupplierService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/suppliers")
@RequiredArgsConstructor
public class SupplierController {
    private final SupplierService supplierService;

    @PostMapping(value = "/saveSupplier")
    public SupplierDTO saveSupplier(@RequestBody SupplierDTO supplierDTO){
        return supplierService.saveSupplier(supplierDTO);
    }
}
