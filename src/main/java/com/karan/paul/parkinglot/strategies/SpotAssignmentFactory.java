package com.karan.paul.parkinglot.strategies;

import com.karan.paul.parkinglot.entities.ParkingSpotAssignmentStrategyType;

public class SpotAssignmentFactory {
    public static LocateParkingSpotStrategy assignSpotAssignmentStartegy(ParkingSpotAssignmentStrategyType parkingSpotAssignmentStrategyType){
        if(parkingSpotAssignmentStrategyType.equals(ParkingSpotAssignmentStrategyType.NEAREST))
            return new FindNearestParkingSpot();
        return null;
    }
}
