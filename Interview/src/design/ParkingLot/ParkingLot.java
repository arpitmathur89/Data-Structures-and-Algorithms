package design.ParkingLot;

/**
 * Created by arpit on 7/4/2017.
 */
public class ParkingLot {

    private Level[] levels;
    private final int numOfLevels = 5;

    ParkingLot(){
        levels = new Level[numOfLevels];
        for(int i=0;i<numOfLevels;i++){
            levels[i] = new Level(i,20);
        }
    }
}
