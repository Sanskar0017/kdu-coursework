package com.kdu.smarthome.mapper;

import com.kdu.smarthome.dto.request.AddInventoryItemRequest;
import com.kdu.smarthome.models.Inventory;

/**
 * Mapper class for mapping AddInventoryItemRequest to Inventory entity.
 */
public class InventoryMapper {

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private InventoryMapper() {
        // Private constructor to hide the implicit public one
    }

    /**
     * Maps an AddInventoryItemRequest object to an Inventory entity.
     *
     * @param addInventoryItemRequest The request object to map.
     * @return The mapped Inventory entity.
     */
    public static Inventory mapToInventory(AddInventoryItemRequest addInventoryItemRequest) {
        return new Inventory(
                addInventoryItemRequest.getKickstoneId(),
                addInventoryItemRequest.getDeviceUsername(),
                addInventoryItemRequest.getDevicePassword(),
                addInventoryItemRequest.getManufactureDateTime(),
                addInventoryItemRequest.getManufactureFactoryPlace()
        );
    }
}
