package com.karan.paul.parkinglot.entities;

import com.karan.paul.parkinglot.strategies.PaymentFactory;
import com.karan.paul.parkinglot.strategies.PaymentModeStrategy;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Bill {
    private Integer id;
    private Ticket ticket;
    private LocalDateTime existTime;
    private Double amount;
    private Operator operator;
    private Gate exitGate;
    private List<Payment> paymentList;

    public void takePayment(PaymentType paymentType) {
        Payment payment = new Payment();
        payment.setBill(this);
        payment.setPaymentType(paymentType);
        payment.setPaymentStatus(PaymentStatus.INPROGRESS);
        payment.setAmount(this.getAmount());

        PaymentModeStrategy paymentModeStrategy = PaymentFactory.getPaymentMode(payment);
        paymentModeStrategy.performPayment(payment.getAmount());
        payment.setPaymentStatus(PaymentStatus.SUCCESS);

        paymentList.add(payment);
    }
}
