package com.sanskar.homeworkspring3.repository;

import com.sanskar.homeworkspring3.model.Vehicle;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * VehicleRepo contains the Vehicle repository
 * find's the most expensive and least based on query parameters
 */
@Data
public class VehicleRepo {

    private List<Vehicle> vehicl = new ArrayList<>();

    public void save(Vehicle vehicls){
        this.vehicl.add(vehicls);
    }

    public Vehicle findById(int id){
        return vehicl.get(id);
    }

    public void updateVehicle(int id, Vehicle vehicles){
        vehicl.get(id).setName(vehicles.getName());
        vehicl.get(id).setPrice(vehicles.getPrice());
    }

    public void delete(int id){
        vehicl.remove(id);
    }

    public Vehicle mostExpensive(){
        Vehicle mostexpensiveVehicle = vehicl.get(0);
        for(int i = 1; i < vehicl.size(); i++){
            Vehicle currentVehicle = vehicl.get(i);
            if(currentVehicle.getPrice() > mostexpensiveVehicle.getPrice()){
                mostexpensiveVehicle = currentVehicle;
            }
        }
        return mostexpensiveVehicle;
    }

    public Vehicle leastExpensive(){
        Vehicle leastexpensiveVehicle = vehicl.get(0);
        for(int i = 1; i < vehicl.size(); i++){
            Vehicle currentVehicle = vehicl.get(i);
            if(currentVehicle.getPrice() > leastexpensiveVehicle.getPrice()){
                leastexpensiveVehicle = currentVehicle;
            }
        }
        return leastexpensiveVehicle;
    }

    public List<Vehicle> getVehicles() {
        return vehicl;
    }
}