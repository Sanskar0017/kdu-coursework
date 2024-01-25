package com.sanskar.homeworkspring3.service;

import com.sanskar.homeworkspring3.model.Vehicle;
import com.sanskar.homeworkspring3.vehicledto.Vehicledto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * VehicleService indicates an interface implementation extending in various child classes
 */
@Service
public interface VehicleService {
    Vehicledto createVehicle(Vehicledto Vehicle);
    Vehicle getVehicleById(int id);
    List<Vehicle> getAllVehicles();
    void updateVehicle(int id, Vehicledto Vehicle);
    void deleteVehicle(int id);
    Vehicle mostExpensive();
    Vehicle leastExpensive();
}
