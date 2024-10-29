package com.karan.paul.parkinglot.DTO;

import com.karan.paul.parkinglot.entities.Gate;
import com.karan.paul.parkinglot.entities.Vehicle;
import lombok.Data;

@Data
public class GenerateTicketForVechile {
    private Vehicle vehicle;
    private Gate entryGate;
}
