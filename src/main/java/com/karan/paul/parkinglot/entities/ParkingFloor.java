package com.karan.paul.parkinglot.entities;

import lombok.Data;

import java.util.List;
@Data
public class ParkingFloor {
    private Integer id;
    private List<ParkingSpot> parkingSpotList;
    private Integer totalCapacity;
    private boolean isFull;
}
