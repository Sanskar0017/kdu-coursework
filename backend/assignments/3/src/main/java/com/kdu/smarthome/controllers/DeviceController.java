package com.kdu.smarthome.controllers;

import com.kdu.smarthome.dto.request.AddDeviceToHouseRequest;
import com.kdu.smarthome.dto.request.RegisterDeviceRequest;
import com.kdu.smarthome.dto.response.AddDeviceToHouseResponse;
import com.kdu.smarthome.dto.response.RegisterDeviceResponse;
import com.kdu.smarthome.services.DevicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/v1/device")
public class DeviceController {
    private final DevicesService devicesService;

    /**
     * Constructor for DeviceController.
     *
     * @param devicesService an instance of DevicesService to handle device-related operations
     */
    @Autowired
    public DeviceController(DevicesService devicesService) {
        this.devicesService = devicesService;
    }

    /**
     * Endpoint to register a device.
     *
     * @param registerDeviceRequest the request object containing details of the device to be registered
     * @return ResponseEntity containing the response object with the result of the registration process
     */
    @PostMapping("/register")
    public ResponseEntity<RegisterDeviceResponse> registerDevice(@RequestBody RegisterDeviceRequest registerDeviceRequest){
        RegisterDeviceResponse registerDeviceResponse = devicesService.registerDevice(registerDeviceRequest);
        return new ResponseEntity<>(registerDeviceResponse, HttpStatus.OK);
    }

    /**
     * Endpoint to add a device to a house.
     *
     * @param addDeviceToHouseRequest the request object containing details of the device and the house to add it to
     * @return AddDeviceToHouseResponse containing the response object with the result of adding the device to the house
     */
    @PostMapping("/add")
    public AddDeviceToHouseResponse addDevice(@RequestBody AddDeviceToHouseRequest addDeviceToHouseRequest){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return devicesService.addDevice(addDeviceToHouseRequest, username);
    }

}
