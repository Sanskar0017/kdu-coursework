package com.sanskar.homeworkspring3.service;

import com.sanskar.homeworkspring3.repository.*;
import com.sanskar.homeworkspring3.model.*;
import com.sanskar.homeworkspring3.mapper.*;
import com.sanskar.homeworkspring3.vehicledto.Vehicledto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of VehicleService interface for managing Vehicle operations,
 * including creation, retrieval, updating, and deletion of Vehicles.
 */
@Service
class VehicleServiceImplementation implements VehicleService{
    private final VehicleRepo inventoryStore = new VehicleRepo();
    public Vehicledto createVehicle(Vehicledto vehicleDto){
        Vehicle vehicle= VehicleMapper.mapToVehicle(vehicleDto);
        inventoryStore.save(vehicle);
        return vehicleDto;
    }


    public Vehicle getVehicleById(int id){
        return inventoryStore.findById(id);

    }
    public List<Vehicle> getAllVehicles(){
        return inventoryStore.getVehicles();
    }
    public void updateVehicle(int id, Vehicledto vehicleDto){
        Vehicle vehicle= VehicleMapper.mapToVehicle(vehicleDto);
        inventoryStore.updateVehicle(id, vehicle);
    }
    public void deleteVehicle(int id){
        inventoryStore.delete(id);
    }
    public Vehicle mostExpensive(){
        return inventoryStore.mostExpensive();
    }
    public Vehicle leastExpensive(){
        return inventoryStore.leastExpensive();
    }
}