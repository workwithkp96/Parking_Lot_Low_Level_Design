package com.karan.paul.parkinglot.strategies;

import com.karan.paul.parkinglot.entities.ParkingFloor;
import com.karan.paul.parkinglot.entities.ParkingSpot;
import com.karan.paul.parkinglot.entities.VehicleType;

public interface LocateParkingSpotStrategy {
    ParkingSpot getAvailableParkingSpot(VehicleType vehicleType, ParkingFloor parkingFloor);
}
