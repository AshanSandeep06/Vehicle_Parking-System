package models;

public class parkingDetails {
    private String vehicleNumber;
    private String vehicleType;
    private String driverName;
    private String parkingSlot;
    private String parkedTime;

    public parkingDetails(String vehicleNumber, String vehicleType, String driverName, String parkingSlot, String parkedTime) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.driverName = driverName;
        this.parkingSlot = parkingSlot;
        this.parkedTime = parkedTime;
    }

    public parkingDetails(String vehicleNumber){
        this.vehicleNumber=vehicleNumber;
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

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(String parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public String getParkedTime() {
        return parkedTime;
    }

    public void setParkedTime(String parkedTime) {
        this.parkedTime = parkedTime;
    }

    @Override
    public String toString() {
        return "parkingDetails{" +
                "vehicleNumber='" + vehicleNumber + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", driverName='" + driverName + '\'' +
                ", parkingSlot='" + parkingSlot + '\'' +
                ", parkedTime='" + parkedTime + '\'' +
                '}';
    }

    public boolean equals(Object obj){
       return obj instanceof parkingDetails ? ((parkingDetails)obj).vehicleNumber==this.vehicleNumber : false;
    }
}
