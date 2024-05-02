package org.example.helloshoesbackend.service;

import org.example.helloshoesbackend.dto.CustomerDTO;

import java.util.List;


public interface CustomerService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    List<CustomerDTO> getAllCustomer();
    CustomerDTO getSelectedCustomer(String id);
    void deleteCustomer(String id);
    void updateCustomer(String id, CustomerDTO customerDTO);
}
