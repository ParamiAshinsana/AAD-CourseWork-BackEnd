package org.example.helloshoesbackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.helloshoesbackend.dto.CustomerDTO;
import org.example.helloshoesbackend.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping(value = "/saveCustomer")
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.saveCustomer(customerDTO);
    }

    @PutMapping(value = "/updateCustomer/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void updateCustomer(@RequestBody CustomerDTO customerDTO, @PathVariable ("id") String id){
        customerService.updateCustomer(id,customerDTO);
        System.out.println("Customer Updated!");
    }

    @DeleteMapping("/deleteCustomer/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteCustomer(@PathVariable ("id") String id){
        customerService.deleteCustomer(id);
    }

//    @GetMapping(value = "/getAllCustomer")
//    public CustomerDTO getAllCustomers(){
//        CustomerDTO customerDTO = new CustomerDTO();
//        customerDTO.setCustomerName("Asd");
//        customerDTO.setCustomerAddress("dfg");
//        return customerDTO;
//    }

    @GetMapping(value = "/getAllCustomer")
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    List<CustomerDTO> getAllCustomers(){
        return customerService.getAllCustomer();
    }

    @GetMapping("/getSelectedCustomer/{id}")
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    ResponseEntity<CustomerDTO> getSelectedCustomer(@PathVariable ("id") String id){
        CustomerDTO selectedCustomer = customerService.getSelectedCustomer(id);
        return selectedCustomer != null ? ResponseEntity.ok(selectedCustomer) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    // To Sale Service Controller
    @GetMapping(value = "/getCustomerName/{id}")
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    public String getCustomerName(@PathVariable("id")String id ){
        return customerService.getCustomerName(id);
    }

    @GetMapping(value = "/getAllCustomerCode")
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    List<String> getAllCustomersCode(){
        return customerService.getAllCustomerCode();
    }
}
