package com.kdu.smarthome.controllers;

import com.kdu.smarthome.dto.request.AddInventoryItemRequest;
import com.kdu.smarthome.dto.response.AddInventoryItemResponse;
import com.kdu.smarthome.dto.response.GetInventoryResponse;
import com.kdu.smarthome.services.InventoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/v1/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    /**
     * Constructs a new InventoryController with the provided InventoryService.
     *
     * @param inventoryService The InventoryService instance to be used by the controller.
     */
    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    /**
     * Handles HTTP POST requests to add inventory items.
     *
     * @param addInventoryItemRequest The request object containing information about the item to be added.
     * @return A ResponseEntity containing the response object with information about the added inventory item,
     * along with an HTTP status code indicating the result of the operation.
     */
    @PostMapping("")
    public ResponseEntity<AddInventoryItemResponse> addInventory(@RequestBody AddInventoryItemRequest addInventoryItemRequest){
        return new ResponseEntity<>(inventoryService.addInventory(addInventoryItemRequest), HttpStatus.OK);
    }

    /**
     * Handles HTTP GET requests to retrieve all inventory items.
     *
     * @return A ResponseEntity containing the response object with information about all inventory items,
     * along with an HTTP status code indicating the result of the operation.
     */
    @GetMapping
    public ResponseEntity<GetInventoryResponse> getAllInventory(){
        return new ResponseEntity<>(inventoryService.getAllInventory(), HttpStatus.OK);
    }

}
