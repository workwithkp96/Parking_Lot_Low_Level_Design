package com.karan.paul.parkinglot.entities;

import lombok.Data;

@Data
public class Gate {
    private Integer id;
    private GateType gateType;
    private Operator operator;
}
