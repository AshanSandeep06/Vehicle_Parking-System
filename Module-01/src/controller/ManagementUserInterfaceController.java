package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;

public class ManagementUserInterfaceController {
    public JFXComboBox<String> cbxOption;
    public AnchorPane tblLoaderContext;
    public JFXButton btnLogOut;
    public AnchorPane managementContext;

    public void initialize() throws IOException {
        ObservableList<String> obList = FXCollections.observableArrayList();
        obList.addAll("In Parking", "On Delivery");
        cbxOption.setItems(obList);

        URL url = getClass().getResource("../view/inParkingTableForm.fxml");
        Parent load1 = FXMLLoader.load(url);
        tblLoaderContext.getChildren().add(load1);

        cbxOption.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals("In Parking")) {
                btnLogOut.setVisible(true);
                URL resource = getClass().getResource("../view/inParkingTableForm.fxml");
                Parent load = null;
                try {
                    load = FXMLLoader.load(resource);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                tblLoaderContext.getChildren().clear();
                tblLoaderContext.getChildren().add(load);
            } else {
                btnLogOut.setVisible(false);
                URL resource = getClass().getResource("../view/onDeliveryTableForm.fxml");
                Parent load = null;
                try {
                    load = FXMLLoader.load(resource);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                tblLoaderContext.getChildren().clear();
                tblLoaderContext.getChildren().add(load);
            }
        });
    }

    public void addVehicleOnAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.setTitle("Add Vehicle");
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/addVehicleForm.fxml"))));
        stage.show();
    }

    public void addDriverOnAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.setTitle("Add Driver");
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/addDriverForm.fxml"))));
        stage.show();
    }

    public void logOutOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) managementContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/firstInterface.fxml"))));
    }
}
