package design.ParkingLot;

/**
 * Created by arpit on 7/4/2017.
 */
public class MotorCycle extends Vehicle {

    public MotorCycle(){
        size = VehicleSize.Motorcycle;
    }

    @Override
    public boolean canFit(ParkingSpot spot) {
        return spot.getSpotSize() == size;
    }

    @Override
    public void print(){
        System.out.println("Parking a Bike");
    }
}
