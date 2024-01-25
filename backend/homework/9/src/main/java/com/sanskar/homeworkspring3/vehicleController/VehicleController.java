package com.sanskar.homeworkspring3.VehicleController;

import com.sanskar.homeworkspring3.exception.MyCustomException;
import com.sanskar.homeworkspring3.model.Vehicle;
import com.sanskar.homeworkspring3.service.VehicleService;
import com.sanskar.homeworkspring3.vehicledto.ErrorDTO;
import com.sanskar.homeworkspring3.vehicledto.Vehicledto;
import com.sanskar.homeworkspring3.vehicledto.ErrorDTO;
import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * VehicleController consist of GET, POST, PUT AND DELETE request
 * using URL and URL parameters
 * Response Entity
 */
@Slf4j
@RestController
@AllArgsConstructor
public class VehicleController {
    private VehicleService VehicleService;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody Vehicledto Vehicle){
        try{
            VehicleService.createVehicle(Vehicle);
            log.info("Success User creation");
            return new ResponseEntity<>("created user successfully", HttpStatus.CREATED);
        }catch(MyCustomException e){
            log.warn("Index out of bounds for user creation");
            return new ResponseEntity<>("IndexoutofBOunds :(", HttpStatus.CREATED);
        }
    }


    @GetMapping("{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable("id") int VehicleId){
        try{
            Vehicle Vehicle = VehicleService.getVehicleById(VehicleId);
            return new ResponseEntity<>(Vehicle, HttpStatus.OK);
        }catch(IndexOutOfBoundsException e){
            throw new MyCustomException("Index provided is out of bounds");
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateVehicle(@PathVariable int id,@RequestBody Vehicledto updatedVehicle) throws MyCustomException  {
        try {
            VehicleService.updateVehicle(id, updatedVehicle);
            return new ResponseEntity<>("Vehicle updated successfully", HttpStatus.CREATED);
        }catch (IndexOutOfBoundsException e) {
            ErrorDTO errorDTO = new ErrorDTO(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            log.warn("\nException handled by Custom Exception\n{}", errorDTO);
            throw new MyCustomException("Vehicle not found");
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteVehicle(@PathVariable("id") int VehicleId){
        VehicleService.deleteVehicle(VehicleId);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }
}
