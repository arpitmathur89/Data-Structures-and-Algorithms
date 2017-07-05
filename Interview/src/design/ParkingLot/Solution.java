package design.ParkingLot;

import java.util.Random;

/**
 * Created by arpit on 7/4/2017.
 */
public class Solution {
    public static void main(String[] args) {
        ParkingLot parkinglot = new ParkingLot();
        Random rand = new Random();
        Vehicle vehicle = null;
        // Get random number inside while loop to decide on which vehicle object to create and then come back
        // to the same while loop but this time vehicle object is not null , so try for parking the vehicle.
        // This logic is just for testing.
        while(vehicle == null || parkinglot.parkVehicle(vehicle)){
            int num = rand.nextInt(8);
            if(num < 2){
                vehicle = new MotorCycle();
            }else if(num < 5){
                vehicle = new Car();
            }else{
                vehicle = new Bus();
            }
            vehicle.print();
        }
    }
}
