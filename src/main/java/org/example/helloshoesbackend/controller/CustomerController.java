package org.example.helloshoesbackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.helloshoesbackend.dto.CustomerDTO;
import org.example.helloshoesbackend.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.saveCustomer(customerDTO);
    }

    @PatchMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateCustomer(@RequestBody CustomerDTO customerDTO, @PathVariable ("id") String id){
        customerService.updateCustomer(id,customerDTO);
        System.out.println("Customer Updated!");
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCustomer(@PathVariable ("id") String id){
        customerService.deleteCustomer(id);
    }

    @GetMapping(produces = "application/json")
    List<CustomerDTO> getAllCustomers(){
        return customerService.getAllCustomer();
    }

    @GetMapping(value = "/{id}",produces = "application/json")
    ResponseEntity<CustomerDTO> getSelectedCustomer(@PathVariable ("id") String id){
        CustomerDTO selectedCustomer = customerService.getSelectedCustomer(id);
        return selectedCustomer != null ? ResponseEntity.ok(selectedCustomer) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
