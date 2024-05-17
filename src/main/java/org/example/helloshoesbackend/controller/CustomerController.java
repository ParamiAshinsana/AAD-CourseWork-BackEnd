package org.example.helloshoesbackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.helloshoesbackend.dto.CustomerDTO;
import org.example.helloshoesbackend.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping(value = "/saveCustomer")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.saveCustomer(customerDTO);
    }

    @PutMapping(value = "/updateCustomer/{id}")
    public void updateCustomer(@RequestBody CustomerDTO customerDTO, @PathVariable ("id") String id){
        customerService.updateCustomer(id,customerDTO);
        System.out.println("Customer Updated!");
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public void deleteCustomer(@PathVariable ("id") String id){
        customerService.deleteCustomer(id);
    }

    @GetMapping(value = "/getAllCustomer")
    List<CustomerDTO> getAllCustomers(){
        return customerService.getAllCustomer();
    }

    @GetMapping("/getSelectedCustomer/{id}")
    ResponseEntity<CustomerDTO> getSelectedCustomer(@PathVariable ("id") String id){
        CustomerDTO selectedCustomer = customerService.getSelectedCustomer(id);
        return selectedCustomer != null ? ResponseEntity.ok(selectedCustomer) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    // To Sale Service Controller
    @GetMapping(value = "/getCustomerName/{id}")
    public String getCustomerName(@PathVariable("id")String id ){
        return customerService.getCustomerName(id);
    }

    @GetMapping(value = "/getAllCustomerCode")
    List<String> getAllCustomersCode(){
        return customerService.getAllCustomerCode();
    }
}
