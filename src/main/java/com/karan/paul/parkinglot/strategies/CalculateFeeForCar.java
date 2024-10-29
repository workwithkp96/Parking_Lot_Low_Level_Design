package com.karan.paul.parkinglot.strategies;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class CalculateFeeForCar implements CalculateFeeForVehicleType{
    @Override
    public Double getBillAmount(LocalDateTime entryTime,LocalDateTime exitTime) {
        long hoursSpent = exitTime.until(entryTime, ChronoUnit.HOURS);
        double price = 0.0;
        if (hoursSpent <= 2) {
            price = hoursSpent * 25;
        } else if (hoursSpent <= 4) {
            // First 2 hours at 25, remaining hours at 30
            price = (2 * 25) + (hoursSpent - 2) * 30;
        } else if (hoursSpent <= 6) {
            // First 2 hours at 25, next 2 hours at 30, remaining hours at 35
            price = (2 * 25) + (2 * 30) + (hoursSpent - 4) * 35;
        } else {
            // First 2 hours at 25, next 2 hours at 30, next 2 hours at 35, remaining hours at 45
            price = (2 * 25) + (2 * 30) + (2 * 35) + (hoursSpent - 6) * 45;
        }

        return price;
    }
}
