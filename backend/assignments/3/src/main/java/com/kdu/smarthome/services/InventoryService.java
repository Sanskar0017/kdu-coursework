package com.kdu.smarthome.services;

import com.kdu.smarthome.dto.request.AddInventoryItemRequest;
import com.kdu.smarthome.dto.response.AddInventoryItemResponse;
import com.kdu.smarthome.dto.response.GetInventoryResponse;
import com.kdu.smarthome.models.Inventory;
import com.kdu.smarthome.repository.InventoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.kdu.smarthome.mapper.InventoryMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class for managing inventory.
 */
@Service
@Slf4j
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    /**
     * Adds an item to the inventory.
     *
     * @param addInventoryItemRequest The request object containing inventory item details.
     * @return A response entity indicating the result of the operation.
     */
    public AddInventoryItemResponse addInventory(AddInventoryItemRequest addInventoryItemRequest) {
        Inventory inventory = InventoryMapper.mapToInventory(addInventoryItemRequest);
        inventoryRepository.save(inventory);
        return new AddInventoryItemResponse(
                "Added to inventory",
                inventory.toString(),
                HttpStatus.OK
        );
    }

    /**
     * Retrieves all items in the inventory.
     *
     * @return A response entity containing a list of inventory items.
     */
    public GetInventoryResponse getAllInventory() {
        List<Inventory> inventoryList = inventoryRepository.findAll();
        String message = "Getting all inventory";
        HttpStatus status = HttpStatus.OK;

        if (inventoryList.isEmpty()) {
            inventoryList = new ArrayList<>(); // Create an empty list
        }

        return new GetInventoryResponse(message, inventoryList, status);
    }
}
