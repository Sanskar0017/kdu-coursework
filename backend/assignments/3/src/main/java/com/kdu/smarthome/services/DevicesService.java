package com.kdu.smarthome.services;

import com.kdu.smarthome.dto.request.AddDeviceToHouseRequest;
import com.kdu.smarthome.dto.request.RegisterDeviceRequest;
import com.kdu.smarthome.dto.response.AddDeviceToHouseResponse;
import com.kdu.smarthome.dto.response.RegisterDeviceResponse;
import com.kdu.smarthome.models.Device;
import com.kdu.smarthome.repository.DevicesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service class responsible for handling operations related to devices.
 */
@Service
@Slf4j
public class DevicesService {

    private final DevicesRepository devicesRepository;

    /**
     * Constructs a new DevicesService with the provided DevicesRepository.
     *
     * @param devicesRepository The repository for accessing device data.
     */
    @Autowired
    public DevicesService(DevicesRepository devicesRepository) {
        this.devicesRepository = devicesRepository;
    }

    /**
     * Registers a new device with the provided device details.
     *
     * @param registerDeviceRequest The request containing device details for registration.
     * @return A response indicating the success of the registration along with the registered device information.
     */
    public RegisterDeviceResponse registerDevice(RegisterDeviceRequest registerDeviceRequest) {
        log.info("Registering a device");
        Optional<Device> device = Optional.of(devicesRepository.findBykickstonId(registerDeviceRequest.getKickstoneId()).orElse(new Device()));

        return new RegisterDeviceResponse("Device registered", device.get().toString(), HttpStatus.OK);
    }

    /**
     * Adds a device to a house with the provided device details and associated username.
     *
     * @param addDeviceToHouseRequest The request containing device details for adding to a house.
     * @param username                The username associated with the device.
     * @return A response indicating the success of adding the device to the house.
     */
    public AddDeviceToHouseResponse addDevice(AddDeviceToHouseRequest addDeviceToHouseRequest, String username) {
        String randomPassword = "test123";
        devicesRepository.save(new Device(
                addDeviceToHouseRequest.getKickstoneId(),
                username,
                randomPassword
        ));

        return new AddDeviceToHouseResponse(
                "Adding device successfully",
                "Device found",
                HttpStatus.OK
        );
    }
}
