package org.example.helloshoesbackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.helloshoesbackend.dto.CustomerDTO;
import org.example.helloshoesbackend.dto.SupplierDTO;
import org.example.helloshoesbackend.service.SupplierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/suppliers")
@RequiredArgsConstructor
public class SupplierController {
    private final SupplierService supplierService;

    @PostMapping(value = "/saveSupplier")
    @PreAuthorize("hasAuthority('ADMIN')")
    public SupplierDTO saveSupplier(@RequestBody SupplierDTO supplierDTO){
        return supplierService.saveSupplier(supplierDTO);
    }

    @PutMapping(value = "/updateSupplier/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void updateSupplier(@RequestBody SupplierDTO supplierDTO, @PathVariable ("id") String id){
        supplierService.updateSupplier(id,supplierDTO);
        System.out.println("Supplier Updated!");
    }

    @DeleteMapping("/deleteSupplier/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteSupplier(@PathVariable ("id") String id){
        supplierService.deleteSupplier(id);
    }

    @GetMapping(value = "/getAllSupplier")
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    List<SupplierDTO> getAllSuppliers(){
        return supplierService.getAllSupplier();
    }

    @GetMapping("/getSelectedSupplier/{id}")
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    ResponseEntity<SupplierDTO> getSelectedSupplier(@PathVariable ("id") String id){
        SupplierDTO selectedSupplier = supplierService.getSelectedSupplier(id);
        return selectedSupplier != null ? ResponseEntity.ok(selectedSupplier) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    // To Inventory Controller
    @GetMapping(value = "/getSupplierName/{id}")
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    public String getSuppliersName(@PathVariable("id")String id ){
        return supplierService.getSupplierName(id);
    }

    @GetMapping(value = "/getAllSupplierCode")
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    List<String> getAllSuppliersCode(){
        return supplierService.getAllSuppliersCode();
    }

}
