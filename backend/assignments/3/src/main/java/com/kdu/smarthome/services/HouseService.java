package com.kdu.smarthome.services;

import com.kdu.smarthome.dto.request.AddUserToHouseRequest;
import com.kdu.smarthome.dto.request.CreateHouseRequest;
import com.kdu.smarthome.dto.request.UpdateHouseAddressRequest;
import com.kdu.smarthome.dto.response.*;
import com.kdu.smarthome.exception.MyCustomException;
import com.kdu.smarthome.exception.ResouceNotFoundException;
import com.kdu.smarthome.models.House;
import com.kdu.smarthome.models.Users;
import com.kdu.smarthome.repository.HouseRepository;
import com.kdu.smarthome.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing houses.
 */
@Service
@Slf4j
public class HouseService {

    private final HouseRepository houseRepository;
    private final UsersRepository usersRepository;

    @Autowired
    public HouseService(HouseRepository houseRepository, UsersRepository usersRepository) {
        this.houseRepository = houseRepository;
        this.usersRepository = usersRepository;
    }

    /**
     * Adds a new house.
     *
     * @param createHouseRequest The request object containing house details.
     * @return A response entity indicating the result of the operation.
     */
    public CreateHouseResponse addHouse(CreateHouseRequest createHouseRequest) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        log.info("Adding house");

        House house = new House(
                createHouseRequest.getAddress(),
                createHouseRequest.getHouseName(),
                usersRepository.findByUsername(userName)
        );

        House updateHouse = houseRepository.save(house);
        return new CreateHouseResponse("Adding House Successfully", updateHouse, HttpStatus.OK);

    }

    /**
     * Retrieves all houses.
     *
     * @return A response entity containing a list of houses.
     */
    public GetHousesResponse getAllHouses() {
        List<House> getAllHouse = houseRepository.findAll();
        return new GetHousesResponse("All houses retrieval success", getAllHouse, HttpStatus.OK);
    }

    /**
     * Retrieves all rooms and devices for a given house.
     *
     * @param houseId The ID of the house.
     * @return A response entity containing rooms and devices information.
     */
    public GetRoomsAndDevicesResponse getAllRoomsDevice(String houseId) {
        try {
            Optional<House> house = houseRepository.findById(Integer.parseInt(houseId));
            if (house.isPresent()) {
                House findHouse = house.get();
                RoomAndDevice roomAndDevice = new RoomAndDevice();
                roomAndDevice.setHouseId(String.valueOf(findHouse.getId()));
                roomAndDevice.setHouseName(findHouse.getHouseName());
                return new GetRoomsAndDevicesResponse(
                        "Successful in retrieving device as well as houses",
                        "House is : " + roomAndDevice.getHouseId() +
                                " & House address is : " + roomAndDevice.getHouseName(),
                        HttpStatus.OK
                );
            } else {
                throw new MyCustomException("Error finding houseId and houseAddress");
            }
        } catch (Exception e) {
            log.info("Error getting all rooms and devices");
            throw new MyCustomException("Error getting all rooms");
        }

    }

    /**
     * Adds a user to a house.
     *
     * @param houseId               The ID of the house.
     * @param addUserToHouseRequest The request object containing user details.
     * @return A response entity indicating the result of the operation.
     * @throws ResouceNotFoundException   If the requested resource is not found.
     */
    public AddUserToHouseResponse addUserToHouseRequest(String houseId, AddUserToHouseRequest addUserToHouseRequest) throws ResouceNotFoundException {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        log.info("userName is {}, from addUserToHouseRequest", userName);

        int findHouseId = Integer.parseInt(houseId);
        Optional<House> house = Optional.of(houseRepository.findById(findHouseId).orElse(new House()));
        if (house.get().getHouseName() == null) {
            log.debug("Error caught in house");
            throw new ResouceNotFoundException("Error adding user to house");
        }

        Users findUser = usersRepository.findByUsername(userName);
        if (findUser == null || findUser.getId() == 0) {
            throw new ResouceNotFoundException("User not found");
        }

        List<Users> usersList = house.get().getUsersList();
        usersList.add(findUser);
        house.get().setUsersList(usersList);

        return new AddUserToHouseResponse("User added successful",
                "Adding user to house",
                HttpStatus.OK
        );
    }

    /**
     * Updates the address of a house.
     *
     * @param houseId                  The ID of the house.
     * @param updateHouseAddressRequest The request object containing updated address details.
     * @return A response entity indicating the result of the operation.
     * @throws ResouceNotFoundException   If the requested resource is not found.
     */
    public UpdateHouseAddressResponse updateHouse(String houseId, UpdateHouseAddressRequest updateHouseAddressRequest) throws ResouceNotFoundException {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        log.info("Updating house, authentication username is : {}", userName);

        int houseIdd = Integer.parseInt(houseId);
        Optional<House> house = houseRepository.findById(houseIdd);

        if (house.get().getHouseName() == null) {
            throw new ResouceNotFoundException("House update fail");
        }

        String address = updateHouseAddressRequest.getNewAddress();
        house.get().setAddress(address);

        return new UpdateHouseAddressResponse(
                "Successfully updated house",
                "Updated address is : " + house.get().getAddress(),
                HttpStatus.OK
        );
    }

}
