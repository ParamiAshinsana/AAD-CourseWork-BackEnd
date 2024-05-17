package org.example.helloshoesbackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.helloshoesbackend.dto.CustomerDTO;
import org.example.helloshoesbackend.dto.SupplierDTO;
import org.example.helloshoesbackend.service.SupplierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping(value = "/updateSupplier/{id}")
    public void updateSupplier(@RequestBody SupplierDTO supplierDTO, @PathVariable ("id") String id){
        supplierService.updateSupplier(id,supplierDTO);
        System.out.println("Supplier Updated!");
    }

    @DeleteMapping("/deleteSupplier/{id}")
    public void deleteSupplier(@PathVariable ("id") String id){
        supplierService.deleteSupplier(id);
    }

    @GetMapping(value = "/getAllSupplier")
    List<SupplierDTO> getAllSuppliers(){
        return supplierService.getAllSupplier();
    }

    @GetMapping("/getSelectedSupplier/{id}")
    ResponseEntity<SupplierDTO> getSelectedCustomer(@PathVariable ("id") String id){
        SupplierDTO selectedSupplier = supplierService.getSelectedSupplier(id);
        return selectedSupplier != null ? ResponseEntity.ok(selectedSupplier) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    @GetMapping(value = "/getSupplierName/{id}")
    public String getSuppliersName(@PathVariable("id")String id ){
        return supplierService.getSupplierName(id);
    }

    @GetMapping(value = "/getAllSupplierCode")
    List<String> getAllSuppliersCode(){
        return supplierService.getAllSuppliersCode();
    }

}
