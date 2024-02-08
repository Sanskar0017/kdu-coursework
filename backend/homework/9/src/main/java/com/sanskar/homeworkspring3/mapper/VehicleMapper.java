package com.sanskar.homeworkspring3.mapper;
import com.sanskar.homeworkspring3.model.Vehicle;
import com.sanskar.homeworkspring3.vehicledto.Vehicledto;

/**
 * VehicleMapper class maps vehicledto class type to vehicle and vice-versa
 * Reflecting DTO design
 *
 * @author Sanskar
 */
public class VehicleMapper {
        public static Vehicledto mapToVehicledto(Vehicle vehicle){
            return new Vehicledto(vehicle.getName(),vehicle.getPrice());
        }
        public static Vehicle mapToVehicle(Vehicledto vehicleDto){
            return new Vehicle(vehicleDto.getName(), vehicleDto.getPrice());
        }
    }

