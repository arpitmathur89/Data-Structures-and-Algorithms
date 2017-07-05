package design.ParkingLot;

/**
 * Created by arpit on 7/4/2017.
 */
public class Car extends Vehicle {

    public Car(){
        size = VehicleSize.Compact;
    }

    @Override
    public boolean canFit(ParkingSpot spot) {
        return spot.getSpotSize() == size;
    }

    @Override
    public void print(){
        System.out.println("Parking a Car");
    }

}
