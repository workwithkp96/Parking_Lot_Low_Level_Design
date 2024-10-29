package com.karan.paul.parkinglot.entities;

import com.karan.paul.parkinglot.strategies.CalculateFeeFactory;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
public class Ticket {
    private Integer id;
    private Vehicle vehicle;
    private LocalDateTime entryTime;
    private Operator operator;
    private ParkingSpot parkingSpot;
    private Gate entryGate;

    public Bill generateBill(Gate exitGate, Operator operator){
        Bill bill = new Bill();
        bill.setTicket(this);
        bill.setOperator(operator);
        bill.setExitGate(exitGate);
        LocalDateTime exitTime = LocalDateTime.now();
        bill.setExistTime(exitTime);
        Double amount = Objects.requireNonNull(CalculateFeeFactory.getCalculateFeeFactory(this))
                .getBillAmount(this.entryTime, exitTime);
        bill.setAmount(amount);
        return bill;
    }
}
