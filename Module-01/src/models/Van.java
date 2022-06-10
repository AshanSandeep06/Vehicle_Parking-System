package models;

import java.util.ArrayList;

public class Van implements Vehicle{
    private String vehicleNumber;
    private String vehicleType;
    private String maximumWeight;
    private int numberOfPassengers;

    //public static int[] reservedSlotsOfVan=new int[]{1,2,3,4,12,13};

    public static ArrayList<Node> reservedSlotsOfVan=new ArrayList<>();

    public Van(String vehicleNumber, String vehicleType, String maximumWeight, int numberOfPassengers) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.maximumWeight = maximumWeight;
        this.numberOfPassengers = numberOfPassengers;
    }

    public Van() {
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


    /* public boolean equals(Object obj) {
       return obj instanceof parkingDetails ? ((parkingDetails) obj).getVehicleNumber() == this.vehicleNumber : false;
   }*/
}
