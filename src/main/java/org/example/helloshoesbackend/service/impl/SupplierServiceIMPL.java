package org.example.helloshoesbackend.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.helloshoesbackend.dto.SupplierDTO;
import org.example.helloshoesbackend.service.SupplierService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SupplierServiceIMPL implements SupplierService {
    @Override
    public SupplierDTO saveSupplier(SupplierDTO supplierDTO) {
        return null;
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
