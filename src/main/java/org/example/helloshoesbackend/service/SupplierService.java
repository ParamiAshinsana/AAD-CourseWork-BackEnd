package org.example.helloshoesbackend.service;

import org.example.helloshoesbackend.dto.SupplierDTO;

import java.util.List;

public interface SupplierService {
    SupplierDTO saveSupplier(SupplierDTO supplierDTO);
    List<SupplierDTO> getAllSupplier();
    SupplierDTO getSelectedSupplier(String id);
    void deleteSupplier(String id);
    void updateSupplier(String id, SupplierDTO supplierDTO);
}
