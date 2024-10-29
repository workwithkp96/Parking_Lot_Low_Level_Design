package com.karan.paul.parkinglot.strategies;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class CalculateFeeForTruck implements CalculateFeeForVehicleType{
    public Double getBillAmount(LocalDateTime entryTime,LocalDateTime exitTime) {
        long hoursSpent = exitTime.until(entryTime, ChronoUnit.HOURS);
        double price = 0.0;
        if (hoursSpent <= 2) {
            price = hoursSpent * 50;
        } else if (hoursSpent <= 4) {
            price = (2 * 50) + (hoursSpent - 2) * 60;
        } else if (hoursSpent <= 6) {
            price = (2 * 50) + (2 * 60) + (hoursSpent - 4) * 65;
        } else {
            price = (2 * 50) + (2 * 60) + (2 * 65) + (hoursSpent - 6) * 80;
        }
        return price;
    }
}
