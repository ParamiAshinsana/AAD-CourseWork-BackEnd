package org.example.helloshoesbackend.utill;

import lombok.RequiredArgsConstructor;
import org.example.helloshoesbackend.dto.CustomerDTO;
import org.example.helloshoesbackend.entity.CustomerEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomerMapping {
    private final ModelMapper mapper;

    public CustomerDTO toCustomerDTO(CustomerEntity customer) {
        return  mapper.map(customer, CustomerDTO.class);
    }
    public CustomerEntity toCustomer(CustomerDTO customerDTO) {
        return  mapper.map(customerDTO, CustomerEntity.class);
    }
    public List<CustomerDTO> toCustomerDTOList(List<CustomerEntity> customers) {
        return mapper.map(customers, List.class);
    }
}
