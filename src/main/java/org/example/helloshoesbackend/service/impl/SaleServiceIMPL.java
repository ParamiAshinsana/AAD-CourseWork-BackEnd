package org.example.helloshoesbackend.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.helloshoesbackend.dto.SaleDTO;
import org.example.helloshoesbackend.entity.CustomerEntity;
import org.example.helloshoesbackend.entity.InventoryEntity;
import org.example.helloshoesbackend.entity.SaleEntity;
import org.example.helloshoesbackend.repository.CustomerDAO;
import org.example.helloshoesbackend.repository.InventoryDAO;
import org.example.helloshoesbackend.repository.SaleDAO;
import org.example.helloshoesbackend.service.SaleService;
import org.example.helloshoesbackend.utill.SaleMapping;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class SaleServiceIMPL implements SaleService {

    private final SaleDAO saleDAO;
    private final SaleMapping saleMapping;
    private final CustomerDAO customerDAO;
    private final InventoryDAO inventoryDAO;

//    @Override
//    public SaleDTO saveSale(SaleDTO saleDTO) {
//        SaleEntity saleEntity = saleMapping.toSale(saleDTO);
//
//        // Extract customer code and find CustomerEntity
//        String customerCode = saleDTO.getCusDTO().getCustomerCode();
//        CustomerEntity customerEntity = customerDAO.findByCustomerCode(customerCode);
//        saleEntity.setCustomerEntity(customerEntity);
//
//        // Extract item code and parse order item quantity
//        String itemCode = saleDTO.getInvDTO().getItemCode();
//        int orderItemQty = Integer.parseInt(saleDTO.getOrderItemQty());
//
//        // Use custom query to decrement item quantity
//        int updatedRows = inventoryDAO.decrementItemQty(itemCode, orderItemQty);
//        if (updatedRows == 0) {
//            throw new IllegalArgumentException("Insufficient inventory for item code: " + itemCode);
//        }
//
//        // Find the updated InventoryEntity
//        InventoryEntity inventoryEntity = inventoryDAO.findByItemCode(itemCode);
//        saleEntity.setInventoryEntities(inventoryEntity);
//
//        // Save the sale entity
//        saleEntity = saleDAO.save(saleEntity);
//
//        return saleMapping.toSaleDTO(saleEntity);
//    }


    @Override
    public SaleDTO saveSale(SaleDTO saleDTO) {
        // Ensure cusDTO and invDTO are not null
        if (saleDTO.getCusDTO() == null || saleDTO.getCusDTO().getCustomerCode() == null) {
            throw new IllegalArgumentException("Customer code is required.");
        }
        if (saleDTO.getInvDTO() == null || saleDTO.getInvDTO().getItemCode() == null) {
            throw new IllegalArgumentException("Item code is required.");
        }

        // Map SaleDTO to SaleEntity
        SaleEntity saleEntity = saleMapping.toSale(saleDTO);

        // Extract customer code and find CustomerEntity
        String customerCode = saleDTO.getCusDTO().getCustomerCode();
        CustomerEntity customerEntity = customerDAO.findByCustomerCode(customerCode);
        saleEntity.setCustomerEntity(customerEntity);

        // Extract item code and parse order item quantity
        String itemCode = saleDTO.getInvDTO().getItemCode();
        int orderItemQty = Integer.parseInt(saleDTO.getOrderItemQty());

        // Use custom query to decrement item quantity
        int updatedRows = inventoryDAO.decrementItemQty(itemCode, orderItemQty);
        if (updatedRows == 0) {
            throw new IllegalArgumentException("Insufficient inventory for item code: " + itemCode);
        }

        // Find the updated InventoryEntity
        InventoryEntity inventoryEntity = inventoryDAO.findByItemCode(itemCode);
        saleEntity.setInventoryEntities(inventoryEntity);

        // Save the sale entity
        saleEntity = saleDAO.save(saleEntity);

        // Map SaleEntity back to SaleDTO and return
        return saleMapping.toSaleDTO(saleEntity);
    }

    @Override
    public List<SaleDTO> getAllSales() {
        return saleMapping.toSaleDTOList(saleDAO.findAll());
    }


//    private final SaleDAO saleDAO;
//    private final SaleMapping saleMapping;
//
//    @Override
//    public SaleDTO saveSale(SaleDTO saleDTO) {
//        SaleEntity saleEntity = saleMapping.toSale(saleDTO);
//
//        saleEntity = saleDAO.save(saleEntity);
//        return saleMapping.toSaleDTO(saleEntity);
//    }
//
//    private final SaleDAO saleDAO;
//    private final SaleMapping saleMapping;
//    private final CustomerDAO customerDAO;
//    private final InventoryDAO inventoryDAO;

//    @Override
//    public SaleDTO saveSale(SaleDTO saleDTO) {
//        // Convert SaleDTO to SaleEntity
//        SaleEntity saleEntity = saleMapping.toSale(saleDTO);
//
//        // Find the associated CustomerEntity and set it to SaleEntity
//        Optional<CustomerEntity> customerEntityOptional = customerDAO.findById(saleDTO.get());
//        if (customerEntityOptional.isPresent()) {
//            saleEntity.setCustomerEntity(customerEntityOptional.get());
//        } else {
//            throw new NotFoundException("Customer not found");
//        }
//
//        // Set the InventoryEntities to SaleEntity
//        saleEntity.setSInventoryEntity(
//                saleDTO.getInventoryCodes().stream()
//                        .map(code -> inventoryDAO.findById(code).orElseThrow(() -> new NotFoundException("Inventory item not found")))
//                        .collect(Collectors.toList())
//        );
//
//        // Save the SaleEntity
//        saleEntity = saleDAO.save(saleEntity);
//
//        // Convert the saved SaleEntity back to SaleDTO
//        return saleMapping.toSaleDTO(saleEntity);
//        return saleDTO;
//    }


//    public boolean placeOrder(PlaceOrderRequestDTO placeOrderRequestDTO) throws NotFoundException {
//        Sale sale = new Sale();
//        sale.setOrder_id(UUID.randomUUID().toString());
//        sale.setCustomer_name(placeOrderRequestDTO.getCustomer_name());
//        sale.setTotal_price(placeOrderRequestDTO.getNet_total());
//        sale.setPurchase_date(new Date());
//        sale.setPayment_method(placeOrderRequestDTO.getPayment_type());
//
//        Sale savedSale = saleRepository.save(sale);
//
//        List<SaleInventoryDetail> saleInventoryDetails = new ArrayList<>();
//        for (OrderItemDTO item : placeOrderRequestDTO.getItems()) {
//            Inventory inventory = inventoryDAO.findById(item.getItem_id()).orElseThrow(() -> new NotFoundException("Item not found"));
//
//            SaleInventoryDetail saleInventoryDetail = new SaleInventoryDetail();
//            saleInventoryDetail.setOrderDetailID(UUID.randomUUID().toString());
//            saleInventoryDetail.setInventory(inventory);
//            saleInventoryDetail.setSale(savedSale);
//            saleInventoryDetail.setItemName(item.getItem_name());
//            saleInventoryDetail.setQuantity(item.getQuantity());
//            saleInventoryDetail.setSize(item.getItem_size());
//            saleInventoryDetail.setUnitPrice(item.getUnit_price());
//            saleInventoryDetail.setSubTotal(item.getTotal_price());
//
//            saleInventoryDetails.add(saleInventoryDetail);
//        }
//        saleInventoryDetailRepository.saveAll(saleInventoryDetails);
//
//        SaleDTO saleDTO = new SaleDTO();
//        saleDTO.setOrder_id(savedSale.getOrder_id());
//        saleDTO.setCustomer_name(savedSale.getCustomer_name());
//        saleDTO.setTotal_price(savedSale.getTotal_price());
//        saleDTO.setPurchase_date(savedSale.getPurchase_date());
//        saleDTO.setPayment_method(savedSale.getPayment_method());
//        saleDTO.setAdded_points(0);
//        saleDTO.setCashier_name("Default Cashier");
//
//        if (saleDTO != null) {
//            return true;
//        }
//        return false;
//    }
}
