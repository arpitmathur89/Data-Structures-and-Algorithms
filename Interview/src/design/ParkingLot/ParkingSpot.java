package design.ParkingLot;

/**
 * Created by arpit on 7/4/2017.
 */
public class ParkingSpot {

    private int spotNumber;
    private Vehicle vehicle;
    private VehicleSize spotSize;
    private Level level;

    public ParkingSpot(int spotNumber, Vehicle vehicle, VehicleSize spotSize, Level level) {
        this.spotNumber = spotNumber;
        this.vehicle = vehicle;
        this.spotSize = spotSize;
        this.level = level;
    }

    public boolean isAvailable(){
        return vehicle == null;
    }

    public boolean canFitVehicle(Vehicle v){
        if(isAvailable() && v.canFit(this))
            return true;
        return false;
    }

    public boolean park(Vehicle v){
        if(!canFitVehicle(v))
            return false;
        vehicle = v;

        return true;

    }


    public int getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public VehicleSize getSpotSize() {
        return spotSize;
    }

    public void setSpotSize(VehicleSize spotSize) {
        this.spotSize = spotSize;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
