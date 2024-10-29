package com.karan.paul.parkinglot.strategies;

import com.karan.paul.parkinglot.entities.Payment;
import com.karan.paul.parkinglot.entities.PaymentType;

public class PaymentFactory {
    public static PaymentModeStrategy getPaymentMode(Payment payment){
        if(payment.equals(PaymentType.CASH))
            return new CashPayment();
        if(payment.equals(PaymentType.CARD))
            return new CardPayment(new RazorpayPaymentAPIService());
        return null;
    }
}
