package design.ParkingLot;

import design.trie.Solution;

/**
 * Created by arpit on 7/4/2017.
 */
public class Level {

    int level;
    private ParkingSpot[] spots;
    private int availableSpots;
    private int carSpots;
    private int busSpots;
    private int mcSpots;

    public Level(int level, int numsSpots){
        this.level = level;
        spots = new ParkingSpot[numsSpots];
        this.availableSpots = numsSpots;
        // Divide the spots among mc, car and bus and set each spots spotsize beforehasnd

        carSpots = numsSpots/2;
        mcSpots = ((numsSpots - carSpots)*2)/3;
        busSpots = numsSpots -carSpots - mcSpots;

        int i;
        for(i = 0;i<carSpots;i++){
            spots[i] = new ParkingSpot(this,i,VehicleSize.Compact);
        }
        while(i<carSpots+mcSpots){
            spots[i] = new ParkingSpot(this,i,VehicleSize.Motorcycle);
        }
        while (i<numsSpots){
            spots[i] = new ParkingSpot(this,i,VehicleSize.Large);
        }
    }

    public int getAvailableSpots(Vehicle v) {

        if(v.getSize().equals(VehicleSize.Compact))
             return getCarSpots() -1;
        else if(v.getSize().equals(VehicleSize.Motorcycle))
            return getMcSpots() -1;
        else if(v.getSize().equals(VehicleSize.Large))
            return getBusSpots() -1;
        else
            return 0;
    }

    public boolean ParkVehicle(Vehicle v){
        if(getAvailableSpots(v) > 0)
            if(findSpot(v))
                return true;
        return false;
    }

    public boolean findSpot(Vehicle v){
        for(int j=0;j<spots.length;j++){
            ParkingSpot spot = spots[j];
            if(spot.getSpotSize().equals(v.getSize()) && spot.isAvailable()){
                if(spot.park(v)){
                    System.out.println(" Your vehicle is parked at level " + level + " and parking spot number " + j);
                    return true;
                }else{
                    return false;
                }
            }
        }
        return false;
    }

    public int getCarSpots() {
        return carSpots;
    }

    public int getBusSpots() {
        return busSpots;
    }

    public int getMcSpots() {
        return mcSpots;
    }
}
