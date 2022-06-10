package models;

import java.util.ArrayList;

public class CargoLorry implements Vehicle{
    private String vehicleNumber;
    private String vehicleType;
    private String maximumWeight;
    private int numberOfPassengers;

    //public static int[] reservedSlotsOfCargoLorry=new int[]{5,6,7,8,9,10,11};

    public static ArrayList<Node> reservedSlotsOfCargoLorry=new ArrayList<>();

    public CargoLorry(String vehicleNumber, String vehicleType, String maximumWeight, int numberOfPassengers) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.maximumWeight = maximumWeight;
        this.numberOfPassengers = numberOfPassengers;
    }

    public CargoLorry() {
    }



    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getMaximumWeight() {
        return maximumWeight;
    }

    public void setMaximumWeight(String maximumWeight) {
        this.maximumWeight = maximumWeight;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    @Override
    public String toString() {
        return vehicleNumber;
    }
}
