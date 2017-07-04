package design.ParkingLot;

import sun.rmi.server.InactiveGroupException;

/**
 * Created by arpit on 7/4/2017.
 */
public class Bus extends Vehicle {

    public Bus(){
        size = VehicleSize.Large;
    }

    @Override
    public boolean canFit(ParkingSpot spot) {
        return spot.getSpotSize() == size;
    }

    @Override
    public void print(){
        System.out.println("Parking a Bus");
    }
}
