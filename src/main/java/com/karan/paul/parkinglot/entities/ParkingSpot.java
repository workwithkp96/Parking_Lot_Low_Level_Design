package com.karan.paul.parkinglot.entities;

import lombok.Data;

@Data
public class ParkingSpot {
    private Integer id;
    private VehicleType vehicleType;
    private Vehicle vehicle;
    private boolean isOccupied;
    private ParkingFloor parkingFloor;
    private ParkingSpotStatus parkingSpotStatus;

}
