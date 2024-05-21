package org.example.helloshoesbackend.utill;


import lombok.RequiredArgsConstructor;

import org.example.helloshoesbackend.dto.SaleDTO;
import org.example.helloshoesbackend.entity.SaleEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SaleMapping {
    private final ModelMapper mapper;

    public SaleDTO toSaleDTO(SaleEntity saleEntity) {
        return  mapper.map(saleEntity, SaleDTO.class);
    }
    public SaleEntity toSale(SaleDTO saleDTO) {
        return  mapper.map(saleDTO, SaleEntity.class);
    }
    public List<SaleDTO> toSaleDTOList(List<SaleEntity> saleEntities) {
        return mapper.map(saleEntities, List.class);
    }
}
