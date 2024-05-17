package org.example.helloshoesbackend.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.helloshoesbackend.dto.CustomerDTO;
import org.example.helloshoesbackend.entity.CustomerEntity;
import org.example.helloshoesbackend.entity.Gender;
import org.example.helloshoesbackend.entity.Level;
import org.example.helloshoesbackend.exception.NotFoundException;
import org.example.helloshoesbackend.repository.CustomerDAO;
import org.example.helloshoesbackend.service.CustomerService;
import org.example.helloshoesbackend.utill.CustomerMapping;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerServiceIMPL implements CustomerService {
    private final CustomerDAO customerDAO;
    private final CustomerMapping customermapping;

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = customermapping.toCustomer(customerDTO);

        customerEntity = customerDAO.save(customerEntity);
        return customermapping.toCustomerDTO(customerEntity);
    }


    @Override
    public List<CustomerDTO> getAllCustomer() {
        return customermapping.toCustomerDTOList(customerDAO.findAll());
    }

    @Override
    public CustomerDTO getSelectedCustomer(String id) {
        if(!customerDAO.existsById(id)) throw new NotFoundException("CustomerController not found");
        return customermapping.toCustomerDTO(customerDAO.getReferenceById(id));
    }

    @Override
    public void deleteCustomer(String id) {
        if(!customerDAO.existsById(id)) throw new NotFoundException("CustomerController not found");
        customerDAO.deleteById(id);
    }

    @Override
    public void updateCustomer(String id, CustomerDTO customerDTO) {
        Optional<CustomerEntity> tmpCustomer = customerDAO.findById(id);
        if(!tmpCustomer.isPresent()) throw new NotFoundException("CustomerController not found");
        tmpCustomer.get().setCustomerName(customerDTO.getCustomerName());
        tmpCustomer.get().setCustomerDOB(customerDTO.getCustomerDOB());
        tmpCustomer.get().setCustomerGender(Gender.valueOf(String.valueOf(customerDTO.getCustomerGender())));
        tmpCustomer.get().setCustomerJoinDate(customerDTO.getCustomerJoinDate());
        tmpCustomer.get().setCustomerLoyaltyPoints(customerDTO.getCustomerLoyaltyPoints());
        tmpCustomer.get().setLoyaltyLevel(Level.valueOf(String.valueOf(customerDTO.getLoyaltyLevel())));
        tmpCustomer.get().setCustomerAddress(customerDTO.getCustomerAddress());
        tmpCustomer.get().setCustomerContact(customerDTO.getCustomerContact());
        tmpCustomer.get().setCustomerEmail(customerDTO.getCustomerEmail());
    }

    @Override
    public String getCustomerName(String id) {
        return null;
    }

    @Override
    public List<String> getAllCustomerCode() {
        return null;
    }


}
