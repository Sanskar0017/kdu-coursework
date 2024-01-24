package com.sanskar.homeworkspring3.vehicleController;

import com.sanskar.homeworkspring3.model.vehicle;
import com.sanskar.homeworkspring3.service.VehicleService;
import com.sanskar.homeworkspring3.vehicledto.vehicledto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class vehicleController {

    private VehicleService vehicleService;

    @PostMapping
    public ResponseEntity<vehicledto> createUser(@RequestBody vehicledto vehicle){
        vehicledto savedvehicle = vehicleService.createVehicle(vehicle);
        return new ResponseEntity<>(savedvehicle, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<vehicle> getVehicleById(@PathVariable("id") int vehicleId){
        vehicle vehicle = vehicleService.getVehicleById(vehicleId);
        return new ResponseEntity<>(vehicle, HttpStatus.OK);
    }

    @PutMapping("/vehicle/{id}")
    public ResponseEntity<String> updateVehicle(@PathVariable int id, @RequestBody vehicledto vehicle) {
        vehicleService.updateVehicle(id, vehicle);
        String updated="updating vehicle value";
        return new ResponseEntity<>(updated, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteVehicle(@PathVariable("id") int vehicleId){
        vehicleService.deleteVehicle(vehicleId);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }


}
