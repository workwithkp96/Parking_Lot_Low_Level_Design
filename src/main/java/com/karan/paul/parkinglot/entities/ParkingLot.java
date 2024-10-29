package com.karan.paul.parkinglot.entities;

import com.karan.paul.parkinglot.DTO.GenerateBillForTicket;
import com.karan.paul.parkinglot.DTO.GenerateTicketForVechile;
import com.karan.paul.parkinglot.strategies.LocateParkingSpotStrategy;
import com.karan.paul.parkinglot.strategies.SpotAssignmentFactory;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Data
public class ParkingLot {
    private Integer id;
    private List<ParkingFloor> parkingFloorList;
    private Integer totalCapacity;
    private List<VehicleType> vehicleTypes;
    private List<Gate> entryGates;
    private List<Gate> exitGates;
    private DisplayBoard displayBoard;
    private ParkingSpotAssignmentStrategyType parkingSpotAssignmentStrategyType;

    public Ticket generateTicket(GenerateTicketForVechile generateTicketForVechile){
        if(checkParkingSpace(generateTicketForVechile.getVehicle().getVehicleType())){
            Ticket ticket = new Ticket();
            ticket.setEntryGate(generateTicketForVechile.getEntryGate());
            ticket.setVehicle(generateTicketForVechile.getVehicle());
            ticket.setOperator(generateTicketForVechile.getEntryGate().getOperator());
            ticket.setEntryTime(LocalDateTime.now());
            ParkingSpot allottedParkingSpot = getAvailableParkingSpot(generateTicketForVechile.getVehicle().getVehicleType());

            bookParkingSpot(allottedParkingSpot);

            return ticket;
        }
        return null;
    }

    private void bookParkingSpot(ParkingSpot allottedParkingSpot) {
        allottedParkingSpot.setOccupied(true);
        allottedParkingSpot.setParkingSpotStatus(ParkingSpotStatus.OCCUPIED);
        displayBoard.decreaseParkingSpotCount(allottedParkingSpot.getVehicleType());
    }

    public ParkingSpot getAvailableParkingSpot(VehicleType vehicleType){
        LocateParkingSpotStrategy locateParkingSpotStrategy = SpotAssignmentFactory
                .assignSpotAssignmentStartegy(parkingSpotAssignmentStrategyType);
        for(ParkingFloor parkingFloor : parkingFloorList){
            ParkingSpot parkingSpot = locateParkingSpotStrategy.getAvailableParkingSpot(vehicleType,parkingFloor);
            if(parkingSpot!=null)
                return parkingSpot;
        }
        return null;
    }

    public boolean checkParkingSpace(VehicleType vehicleType){
        return displayBoard.checkAvailability(vehicleType);
    }


    public void getBill(GenerateBillForTicket generateBillForTicket){
        Bill bill = generateBillForTicket.getTicket().generateBill(generateBillForTicket.getExitGate(),
                generateBillForTicket.getExitGate().getOperator());
        makePayment(bill,generateBillForTicket.getPaymentType());
        displayBoard.decreaseParkingSpotCount(generateBillForTicket.getTicket().getParkingSpot().getVehicleType());
        generateBillForTicket.getTicket().getParkingSpot().setOccupied(false);
        generateBillForTicket.getTicket().getParkingSpot().setParkingSpotStatus(ParkingSpotStatus.UNOCCUPIED);
    }

    public void makePayment(Bill bill, PaymentType paymentType){
        bill.takePayment(paymentType);
    }
}
