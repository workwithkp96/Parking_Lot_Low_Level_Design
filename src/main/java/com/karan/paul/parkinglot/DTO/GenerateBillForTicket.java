package com.karan.paul.parkinglot.DTO;

import com.karan.paul.parkinglot.entities.Gate;
import com.karan.paul.parkinglot.entities.PaymentType;
import com.karan.paul.parkinglot.entities.Ticket;
import lombok.Data;

@Data
public class GenerateBillForTicket {
    private Ticket ticket;
    private Gate exitGate;
    private PaymentType paymentType;
}
