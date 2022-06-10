package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.parkingDetails;
import modelsTM.deliveryDetailsTM;
import modelsTM.parkingDetailsTM;

public class OnDeliveryTableFormController {
    public TableView tblOnDeliveryVehicleList;
    public TableColumn colVehicleNo;
    public TableColumn colVeType;
    public TableColumn colDriverName;
    public TableColumn colLeftTime;

    public void initialize(){
        colVehicleNo.setCellValueFactory(new PropertyValueFactory("vehicleNumber"));
        colVeType.setCellValueFactory(new PropertyValueFactory("VehicleType"));
        colDriverName.setCellValueFactory(new PropertyValueFactory("driverName"));
        colLeftTime.setCellValueFactory(new PropertyValueFactory("leftTime"));

        loadAllDeliveryDetails();
    }

    public void loadAllDeliveryDetails(){
        ObservableList<deliveryDetailsTM> observableList= FXCollections.observableArrayList();
        for(parkingDetails p1 : FirstInterfaceController.deliveryDetailsArrayList){
            deliveryDetailsTM tm=new deliveryDetailsTM(p1.getVehicleNumber(), p1.getVehicleType(), p1.getDriverName(), p1.getParkedTime());
            observableList.add(tm);
        }
        tblOnDeliveryVehicleList.setItems(observableList);
    }
}
