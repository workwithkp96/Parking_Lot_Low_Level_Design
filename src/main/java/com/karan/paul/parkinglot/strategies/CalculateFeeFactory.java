package com.karan.paul.parkinglot.strategies;

import com.karan.paul.parkinglot.entities.Ticket;
import com.karan.paul.parkinglot.entities.VehicleType;

public class CalculateFeeFactory {
    public static CalculateFeeForVehicleType getCalculateFeeFactory(Ticket ticket){
        if(ticket.getVehicle().getVehicleType().equals(VehicleType.BIKE))
            return new CalculateFeeForBike();
        else if(ticket.getVehicle().getVehicleType().equals(VehicleType.CAR))
            return new CalculateFeeForCar();
        else if(ticket.getVehicle().getVehicleType().equals(VehicleType.TRUCK))
            return new CalculateFeeForTruck();
        return null;
    }
}
