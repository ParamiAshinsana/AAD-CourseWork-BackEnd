package org.example.helloshoesbackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.helloshoesbackend.service.SupplierService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("api/v1/suppliers")
@RequiredArgsConstructor
public class SupplierController {
    private final SupplierService supplierService;
}
