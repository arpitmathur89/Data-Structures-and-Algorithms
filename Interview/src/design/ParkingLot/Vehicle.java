package design.ParkingLot;

/**
 * Created by arpit on 7/4/2017.
 */
public abstract class Vehicle {

    protected String licenseplate;
    protected VehicleSize size;

    public String getLicenseplate() {
        return licenseplate;
    }

    public VehicleSize getSize() {
        return size;
    }

    public abstract boolean canFit(ParkingSpot spot);

    public abstract void print();
}
