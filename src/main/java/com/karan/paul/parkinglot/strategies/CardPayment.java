package com.karan.paul.parkinglot.strategies;

public class CardPayment implements PaymentModeStrategy{
    private PaymentAPIService paymentAPIService;

    CardPayment(PaymentAPIService paymentAPIService){
        this.paymentAPIService=paymentAPIService;
    }
    @Override
    public void performPayment(Double amount) {
        paymentAPIService.doPayment(amount);
    }
}
