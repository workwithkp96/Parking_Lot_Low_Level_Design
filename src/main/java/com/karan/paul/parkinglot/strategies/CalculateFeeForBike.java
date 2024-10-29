package com.karan.paul.parkinglot.strategies;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class CalculateFeeForBike implements CalculateFeeForVehicleType{
    public Double getBillAmount(LocalDateTime entryTime,LocalDateTime exitTime) {
        long hoursSpent = exitTime.until(entryTime, ChronoUnit.HOURS);
        double price = 0.0;
        if (hoursSpent <= 2) {
            price = hoursSpent * 20;
        } else if (hoursSpent <= 4) {
            price = (2 * 20) + (hoursSpent - 2) * 25;
        } else if (hoursSpent <= 6) {
            price = (2 * 20) + (2 * 25) + (hoursSpent - 4) * 30;
        } else {
            price = (2 * 20) + (2 * 25) + (2 * 30) + (hoursSpent - 6) * 40;
        }
        return price;
    }
}
