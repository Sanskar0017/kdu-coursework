package com.kdu.smarthome.services;

import com.kdu.smarthome.dto.response.CreateRoomResponse;
import com.kdu.smarthome.exception.ExecutionError;
import com.kdu.smarthome.models.House;
import com.kdu.smarthome.models.Room;
import com.kdu.smarthome.repository.HouseRepository;
import com.kdu.smarthome.repository.RoomsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service class for managing rooms.
 */
@Service
@Slf4j
public class RoomService {

    private final RoomsRepository roomsRepository;
    private final HouseRepository houseRepository;

    @Autowired
    public RoomService(RoomsRepository roomsRepository, HouseRepository houseRepository) {
        this.roomsRepository = roomsRepository;
        this.houseRepository = houseRepository;
    }

    /**
     * Adds a new room to a house.
     *
     * @param houseId  The ID of the house.
     * @param roomName The name of the room to be added.
     * @return A response entity indicating the result of the operation.
     * @throws ExecutionError If an error occurs during the execution of the operation.
     */
    public CreateRoomResponse addRoom(String houseId, String roomName) throws ExecutionError {
        try {
            Optional<House> findHouse = houseRepository.findById(Integer.parseInt(houseId));
            if (findHouse.isPresent()) {
                Room room = new Room();
                room.setId(room.getId() + 1);
                room.setRoomName(roomName);
                roomsRepository.save(room);
                return new CreateRoomResponse("Success in creating new room",
                        room,
                        HttpStatus.OK
                );
            } else {
                throw new ExecutionError("House not present!");
            }
        } catch (Exception e) {
            log.info("House Id not found");
            throw new ExecutionError("No house with house id " + houseId);
        }
    }
}
