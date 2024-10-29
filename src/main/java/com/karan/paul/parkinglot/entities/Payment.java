package com.karan.paul.parkinglot.entities;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Payment {
    private Integer id;
    private Bill bill;
    private PaymentStatus paymentStatus;
    private PaymentType paymentType;
    private Double amount;
    private Timestamp createdDate;
}
