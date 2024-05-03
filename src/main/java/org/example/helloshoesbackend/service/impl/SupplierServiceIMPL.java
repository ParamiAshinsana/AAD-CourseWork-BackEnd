package org.example.helloshoesbackend.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.helloshoesbackend.dto.SupplierDTO;
import org.example.helloshoesbackend.entity.CustomerEntity;
import org.example.helloshoesbackend.entity.Gender;
import org.example.helloshoesbackend.entity.Level;
import org.example.helloshoesbackend.entity.SupplierEntity;
import org.example.helloshoesbackend.exception.NotFoundException;
import org.example.helloshoesbackend.repository.SupplierDAO;
import org.example.helloshoesbackend.service.SupplierService;
import org.example.helloshoesbackend.utill.SupplierMapping;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class SupplierServiceIMPL implements SupplierService {
    private final SupplierDAO supplierDAO;
    private final SupplierMapping supplierMapping;

    @Override
    public SupplierDTO saveSupplier(SupplierDTO supplierDTO) {
        SupplierEntity supplierEntity = supplierMapping.toSupplier(supplierDTO);

        supplierEntity = supplierDAO.save(supplierEntity);
        return supplierMapping.toSupplierDTO(supplierEntity);
    }

    @Override
    public List<SupplierDTO> getAllSupplier() {
        return supplierMapping.toSupplierDTOList(supplierDAO.findAll());
    }

    @Override
    public SupplierDTO getSelectedSupplier(String id) {
        if(!supplierDAO.existsById(id)) throw new NotFoundException("Supplier not found");
        return supplierMapping.toSupplierDTO(supplierDAO.getReferenceById(id));
    }

    @Override
    public void deleteSupplier(String id) {
        if(!supplierDAO.existsById(id)) throw new NotFoundException("Supplier not found");
        supplierDAO.deleteById(id);
    }

    @Override
    public void updateSupplier(String id, SupplierDTO supplierDTO) {
        Optional<SupplierEntity> tmpSupplier = supplierDAO.findById(id);
        if(!tmpSupplier.isPresent()) throw new NotFoundException("SupplierController not found");
        tmpSupplier.get().setSupplierName(supplierDTO.getSupplierName());
        tmpSupplier.get().setCategory(supplierDTO.getCategory());
        tmpSupplier.get().setSupplierAddress01(supplierDTO.getSupplierAddress01());
        tmpSupplier.get().setSupplierAddress02(supplierDTO.getSupplierAddress02());
        tmpSupplier.get().setSupplierAddress03(supplierDTO.getSupplierAddress03());
        tmpSupplier.get().setSupplierAddress04(supplierDTO.getSupplierAddress04());
        tmpSupplier.get().setSupplierAddress05(supplierDTO.getSupplierAddress05());
        tmpSupplier.get().setSupplierAddress06(supplierDTO.getSupplierAddress06());
        tmpSupplier.get().setContactNo01(supplierDTO.getContactNo01());
        tmpSupplier.get().setContactNo02(supplierDTO.getContactNo02());
        tmpSupplier.get().setSupplierEmail(supplierDTO.getSupplierEmail());
    }
}
