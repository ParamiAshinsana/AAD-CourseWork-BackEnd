package org.example.helloshoesbackend.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.helloshoesbackend.dto.SupplierDTO;
import org.example.helloshoesbackend.entity.SupplierEntity;
import org.example.helloshoesbackend.repository.SupplierDAO;
import org.example.helloshoesbackend.service.SupplierService;
import org.example.helloshoesbackend.utill.SupplierMapping;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    @Override
    public SupplierDTO getSelectedSupplier(String id) {
        return null;
    }

    @Override
    public void deleteSupplier(String id) {

    }

    @Override
    public void updateSupplier(String id, SupplierDTO supplierDTO) {

    }
}
