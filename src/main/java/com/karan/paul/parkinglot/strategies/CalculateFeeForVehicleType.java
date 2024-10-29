package com.karan.paul.parkinglot.strategies;

import java.time.LocalDateTime;

public interface CalculateFeeForVehicleType {
    Double getBillAmount(LocalDateTime entryTime, LocalDateTime exitTime);
}
