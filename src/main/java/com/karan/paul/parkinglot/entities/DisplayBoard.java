package com.karan.paul.parkinglot.entities;

import lombok.Data;

@Data
public class DisplayBoard {
    private Integer availableCarSpace;
    private Integer availableBikeSpace;
    private Integer availableTruckSpace;

    public boolean checkAvailability(VehicleType vehicleType){
        if(vehicleType.equals(VehicleType.CAR) && availableCarSpace>0){
            return true;
        }else if(vehicleType.equals(VehicleType.BIKE) && availableBikeSpace>0){
            return true;
        }else if(vehicleType.equals(VehicleType.TRUCK) && availableTruckSpace>0){
            return true;
        }
        return false;
    }

    public void decreaseParkingSpotCount(VehicleType vehicleType) {
        if(vehicleType.equals(VehicleType.CAR)){
            -- availableCarSpace;
        }else if(vehicleType.equals(VehicleType.BIKE) ){
            -- availableBikeSpace;
        }else if(vehicleType.equals(VehicleType.TRUCK)){
            -- availableTruckSpace;
        }
    }

    public void increaseParkingSpotCount(VehicleType vehicleType) {
        if(vehicleType.equals(VehicleType.CAR)){
            ++availableCarSpace;
        }else if(vehicleType.equals(VehicleType.BIKE) ){
            ++availableBikeSpace;
        }else if(vehicleType.equals(VehicleType.TRUCK)){
            ++availableTruckSpace;
        }
    }
}
