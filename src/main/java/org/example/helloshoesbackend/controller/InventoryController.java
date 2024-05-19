package org.example.helloshoesbackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.helloshoesbackend.dto.InventoryDTO;
import org.example.helloshoesbackend.dto.SupplierDTO;
import org.example.helloshoesbackend.service.InventoryService;
import org.example.helloshoesbackend.utilMatters.UtilMatters;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


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
            @RequestParam("iSize")String iSize,
            @RequestParam("iQty")String iQty,
            @RequestParam("supCode")String supCode,
            @RequestParam("iUnitPriceSale")String iUnitPriceSale,
            @RequestParam("iUnitPriceBuy")String iUnitPriceBuy,
            @RequestParam("iExpectedProfit")String iExpectedProfit,
            @RequestParam("iProfitMargin")String iProfitMargin){
        String base64ProPic = UtilMatters.convertBase64(files);
        inventoryDTO.setItemCode(iCode);
        inventoryDTO.setItemDescription(iDesc);
        inventoryDTO.setItemPicture(base64ProPic);
        inventoryDTO.setCategory(iCategory);
        inventoryDTO.setItemSize(Integer.parseInt(iSize));
        inventoryDTO.setItemQty(Integer.parseInt(iQty));
        SupplierDTO supplierDTO=new SupplierDTO();
        supplierDTO.setSupplierCode(supCode);
        inventoryDTO.setSupplierEntity(supplierDTO);
        inventoryDTO.setUnitPriceSale(Double.parseDouble(iUnitPriceSale));
        inventoryDTO.setUnitPriceBuy(Double.parseDouble(iUnitPriceBuy));
        inventoryDTO.setExpectedProfit(Double.parseDouble(iExpectedProfit));
        inventoryDTO.setProfitMargin(Double.parseDouble(iProfitMargin));
        System.out.println(iCode);
        System.out.println(iDesc);
        System.out.println(iSize);
        System.out.println(supCode);
        System.out.println(iQty);

        return inventoryService.saveInventory(inventoryDTO);

    }

    @GetMapping(value = "/getAllInventory")
    List<InventoryDTO> getAllInventories(){
        System.out.println("get Controller");
        System.out.println(inventoryDTO);
        return inventoryService.getAllInventory();
    }

    @DeleteMapping("/deleteInventory/{id}")
    public void deleteInventory(@PathVariable ("id") String id){
        inventoryService.deleteInventory(id);
    }


    // To Sale Service Controller
    @GetMapping(value = "/getAllItemCodes")
    List<String> getAllItemCode(){
        return inventoryService.getAllItemCodes();
    }

    @GetMapping(value = "/getInventoryDescription/{id}")
    public List<InventoryDTO> getInventoryDescriptions(@PathVariable("id")String id ){
        return inventoryService.getInventoryDescription(id);
    }

    @GetMapping(value = "/getInventoryPrice/{id}")
    public String getInventoryPrice(@PathVariable("id")String id ){
        return inventoryService.getInventoryPrices(id);
    }

    @GetMapping(value = "/getShoeSize/{id}")
    public String getAllShoeSize(@PathVariable("id")String id ){
        return inventoryService.getShoeSizes(id);
    }
}
