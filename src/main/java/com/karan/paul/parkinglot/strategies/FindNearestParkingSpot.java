package com.karan.paul.parkinglot.strategies;

import com.karan.paul.parkinglot.entities.ParkingFloor;
import com.karan.paul.parkinglot.entities.ParkingSpot;
import com.karan.paul.parkinglot.entities.VehicleType;

import java.util.Comparator;
import java.util.List;

public class FindNearestParkingSpot implements LocateParkingSpotStrategy{
    @Override
    public ParkingSpot getAvailableParkingSpot(VehicleType vehicleType, ParkingFloor parkingFloor) {
        List<ParkingSpot> parkingSpotsForVahicleType = parkingFloor.getParkingSpotList().stream()
                .filter(parkingSpot -> vehicleType.equals(parkingSpot.getVehicleType()) && !parkingSpot.isOccupied())
                .sorted(Comparator.comparing(ParkingSpot::getId))
                .toList();
        if(!parkingSpotsForVahicleType.isEmpty())
            return parkingSpotsForVahicleType.getFirst();
        return null;
    }
}
