package org.example.helloshoesbackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.helloshoesbackend.dto.InventoryDTO;
import org.example.helloshoesbackend.service.InventoryService;
import org.example.helloshoesbackend.utilMatters.UtilMatters;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@CrossOrigin
@RestController
@RequestMapping("api/v1/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;
    InventoryDTO inventoryDTO = new InventoryDTO();

    @PostMapping(value = "/saveInventory")
    public InventoryDTO saveInventories(
            @RequestParam("iCode")String iCode,
            @RequestParam("iDesc")String iDesc,
            @RequestParam("files") MultipartFile files,
            @RequestParam("iCategory")String iCategory,
            @RequestParam("iQty")String iQty,
            @RequestParam("iSize")String iSize,
            @RequestParam("iUnitPriceSale")String iUnitPriceSale,
            @RequestParam("iUnitPriceBuy")String iUnitPriceBuy,
            @RequestParam("iExpectedProfit")String iExpectedProfit,
            @RequestParam("iProfitMargin")String iProfitMargin){
        String base64ProPic = UtilMatters.convertBase64(files);
        inventoryDTO.setItemCode(iCode);
        inventoryDTO.setItemDescription(iDesc);
        inventoryDTO.setItemPicture(base64ProPic);
        inventoryDTO.setCategory(iCategory);
        inventoryDTO.setItemQty(Integer.parseInt(iQty));
        inventoryDTO.setItemSize(Integer.parseInt(iSize));
        inventoryDTO.setUnitPriceSale(Double.parseDouble(iUnitPriceSale));
        inventoryDTO.setUnitPriceBuy(Double.parseDouble(iUnitPriceBuy));
        inventoryDTO.setExpectedProfit(Double.parseDouble(iExpectedProfit));
        inventoryDTO.setProfitMargin(Double.parseDouble(iProfitMargin));

        return inventoryService.saveInventory(inventoryDTO);

    }
}
