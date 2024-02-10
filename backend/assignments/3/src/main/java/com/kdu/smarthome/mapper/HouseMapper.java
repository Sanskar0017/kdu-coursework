package com.kdu.smarthome.mapper;

import com.kdu.smarthome.dto.request.CreateHouseRequest;
import com.kdu.smarthome.models.House;

/**
 * Mapper class for mapping CreateHouseRequest to House entity.
 */
public class HouseMapper {

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private HouseMapper() {
        // Private constructor to hide the implicit public one
    }

    /**
     * Maps a CreateHouseRequest object to a House entity.
     *
     * @param createHouseRequest The request object to map.
     * @return The mapped House entity.
     */
    public static House mapToHouse(CreateHouseRequest createHouseRequest){
        House house = new House();
        house.setHouseName(createHouseRequest.getHouseName());
        house.setAddress(createHouseRequest.getAddress());
        return house;
    }
}
