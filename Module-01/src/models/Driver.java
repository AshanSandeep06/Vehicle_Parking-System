package models;

import db.Database2;

public class Driver {
    private String driverName;
    private String driverNic;
    private String lisceneNo;
    private String address;
    private String contactNumber;

    public Driver(String driverName, String driverNic, String lisceneNo, String address, String contactNumber) {
        this.driverName = driverName;
        this.driverNic = driverNic;
        this.lisceneNo = lisceneNo;
        this.address = address;
        this.contactNumber = contactNumber;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverNic() {
        return driverNic;
    }

    public void setDriverNic(String driverNic) {
        this.driverNic = driverNic;
    }

    public String getLisceneNo() {
        return lisceneNo;
    }

    public void setLisceneNo(String lisceneNo) {
        this.lisceneNo = lisceneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return driverName;
    }

    public boolean equals(Object obj){

        //return obj instanceof Driver ? ((Driver)obj).driverNic==this.driverNic : false;

        if(obj instanceof Driver){
            return ((Driver)obj).driverNic==this.driverNic;
        }else{
            return false;
        }
    }
}
