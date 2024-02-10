package com.kdu.smarthome.controllers;

import com.kdu.smarthome.dto.response.CreateRoomResponse;
import com.kdu.smarthome.exception.ExecutionError;
import com.kdu.smarthome.services.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class RoomController {

    private final RoomService roomService;

    /**
     * Constructs a new RoomController with the provided RoomService.
     *
     * @param roomService The service responsible for handling room-related operations.
     */
    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    /**
     * Adds a new room to a house based on the provided house ID and room name.
     *
     * @param houseId   The ID of the house to which the room will be added.
     * @param roomName  The name of the room to be added.
     * @return A ResponseEntity containing the response data for creating a new room.
     * @throws ExecutionError If an error occurs during the execution of the operation.
     */
    @PostMapping("/room")
    public ResponseEntity<CreateRoomResponse> addRoom(@RequestParam String houseId, @RequestBody String roomName) throws ExecutionError {
        CreateRoomResponse createRoomResponse = roomService.addRoom(houseId, roomName);
        return new ResponseEntity<>(createRoomResponse, HttpStatus.OK);
    }
}
