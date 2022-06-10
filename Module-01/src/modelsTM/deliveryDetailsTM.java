package modelsTM;

public class deliveryDetailsTM {
    private String vehicleNumber;
    private String VehicleType;
    private String driverName;
    private String leftTime;

    public deliveryDetailsTM(String vehicleNumber, String vehicleType, String driverName, String leftTime) {
        this.vehicleNumber = vehicleNumber;
        this.VehicleType = vehicleType;
        this.driverName = driverName;
        this.leftTime = leftTime;
    }

    public deliveryDetailsTM() {
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return VehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.VehicleType = vehicleType;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getLeftTime() {
        return leftTime;
    }

    public void setLeftTime(String leftTime) {
        this.leftTime = leftTime;
    }

    @Override
    public String toString() {
        return "deliveryDetailsTM{" +
                "vehicleNumber='" + vehicleNumber + '\'' +
                ", vehicleType='" + VehicleType + '\'' +
                ", driverName='" + driverName + '\'' +
                ", leftTime='" + leftTime + '\'' +
                '}';
    }
}
