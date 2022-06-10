package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.parkingDetails;
import modelsTM.parkingDetailsTM;

public class InParkingTableFormController {
    public TableView tblInParkingVehicleList;
    public TableColumn colVehicleNumber;
    public TableColumn colVehicleType;
    public TableColumn colParkingSlot;
    public TableColumn colParkedTime;

    public void initialize(){
        colVehicleNumber.setCellValueFactory(new PropertyValueFactory("vehicleNumber"));
        colVehicleType.setCellValueFactory(new PropertyValueFactory("vehicleType"));
        colParkingSlot.setCellValueFactory(new PropertyValueFactory("parkingSlot"));
        colParkedTime.setCellValueFactory(new PropertyValueFactory("parkedTime"));

        loadAllParkingDetails();
    }

    public void loadAllParkingDetails(){
        ObservableList<parkingDetailsTM> obList= FXCollections.observableArrayList();
        for(parkingDetails p1 : FirstInterfaceController.parkingDetailsArrayList){
            parkingDetailsTM tm=new parkingDetailsTM(p1.getVehicleNumber(), p1.getVehicleType(), p1.getParkingSlot(), p1.getParkedTime());
            obList.add(tm);
        }
        tblInParkingVehicleList.setItems(obList);
    }
}
