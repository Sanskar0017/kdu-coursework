package com.kdu.smarthome.controllers;

import com.kdu.smarthome.dto.request.AddUserToHouseRequest;
import com.kdu.smarthome.dto.request.CreateHouseRequest;
import com.kdu.smarthome.dto.request.UpdateHouseAddressRequest;
import com.kdu.smarthome.dto.response.*;
import com.kdu.smarthome.exception.InvalidCredentialsException;
import com.kdu.smarthome.exception.ResouceNotFoundException;
import com.kdu.smarthome.services.HouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class HouseController {

    private final HouseService houseService;

    /**
     * Constructor for HouseController.
     *
     * @param houseService The service responsible for house-related operations.
     */
    @Autowired
    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    /**
     * POST endpoint for adding a new house.
     *
     * @param createHouseRequest The request body containing details of the house to be added.
     * @return ResponseEntity containing the response with details of the newly added house.
     */
    @PostMapping("/house")
    public ResponseEntity<CreateHouseResponse> addHouse(@Valid @RequestBody CreateHouseRequest createHouseRequest){
        log.info("Adding House in Place !");
        return new ResponseEntity<>(houseService.addHouse(createHouseRequest), HttpStatus.OK);
    }

    /**
     * GET endpoint for retrieving all houses.
     *
     * @return ResponseEntity containing the response with details of all houses.
     */
    @GetMapping("/house")
    public ResponseEntity<GetHousesResponse> getAllHouses(){
        log.info("Getting all houses");
        GetHousesResponse getHousesResponse = houseService.getAllHouses();
        return new ResponseEntity<>(getHousesResponse, HttpStatus.OK);
    }

    /**
     * GET endpoint for retrieving all rooms and devices within a house.
     *
     * @param houseId The ID of the house for which rooms and devices are to be retrieved.
     * @return ResponseEntity containing the response with details of all rooms and devices within the specified house.
     */
    @GetMapping("/house/{houseId}")
    public ResponseEntity<GetRoomsAndDevicesResponse> getAllRoomsAndDevices(@PathVariable String houseId){
        log.info("Getting all rooms and devices");
        GetRoomsAndDevicesResponse getRoomsAndDevicesResponse = houseService.getAllRoomsDevice(houseId);
        return new ResponseEntity<>(getRoomsAndDevicesResponse, HttpStatus.OK);
    }

    /**
     * POST endpoint for adding a user to a house.
     *
     * @param houseId The ID of the house to which the user is to be added.
     * @param addUserToHouseRequest The request body containing details of the user to be added.
     * @return ResponseEntity containing the response with details of the user addition.
     * @throws ResouceNotFoundException if the specified house is not found.
     * @throws InvalidCredentialsException if the provided credentials are invalid.
     */
    @PostMapping("/house/{houseId}/add-user")
    public ResponseEntity<AddUserToHouseResponse> addUserToHouseRequest(@Valid @PathVariable("houseId") String houseId, @RequestBody AddUserToHouseRequest addUserToHouseRequest) throws ResouceNotFoundException, InvalidCredentialsException {
        AddUserToHouseResponse addUserToHouseResponse = houseService.addUserToHouseRequest(houseId, addUserToHouseRequest);
        return new ResponseEntity<>(addUserToHouseResponse, HttpStatus.OK);
    }

    /**
     * PUT endpoint for updating house address.
     *
     * @param houseId The ID of the house to be updated.
     * @param updateHouseAddressRequest The request body containing the updated address details.
     * @return ResponseEntity containing the response with details of the updated house address.
     * @throws ResouceNotFoundException if the specified house is not found.
     * @throws InvalidCredentialsException if the provided credentials are invalid.
     */
    @PutMapping("/house")
    public ResponseEntity<UpdateHouseAddressResponse> updateHouse(@RequestParam String houseId, @RequestBody UpdateHouseAddressRequest updateHouseAddressRequest) throws ResouceNotFoundException, InvalidCredentialsException {
        log.info("Updating house");
        UpdateHouseAddressResponse updateHouseAddressResponse = houseService.updateHouse(houseId, updateHouseAddressRequest);
        return new ResponseEntity<>(updateHouseAddressResponse, HttpStatus.OK);
    }
}
