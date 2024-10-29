package com.karan.paul.parkinglot.strategies;

public class CashPayment implements PaymentModeStrategy{
    @Override
    public void performPayment(Double amount) {
        System.out.println("Recieved cash");
    }
}
