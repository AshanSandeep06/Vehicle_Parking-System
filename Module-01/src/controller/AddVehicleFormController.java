package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import db.Database1;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Bus;
import models.CargoLorry;
import models.Van;
import models.Vehicle;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddVehicleFormController extends Loader {

    public AnchorPane addVehicleContext;
    public TextField txtVehicleNumber;
    public TextField txtMaximumWeight;
    public TextField txtNoOfPassengers;
    public JFXComboBox<String> cbxVehicleType;

    public Label vehicleLabel1;
    public Label vehicleLabel2;
    public Label vehicleLabel3;

    public static int attempts1=0;
    public static int attempts2=0;
    public static int attempts3=0;


    public void initialize() {
        cbxVehicleType.getItems().addAll("Van", "Bus", "Cargo Lorry");
    }

    public void addVehicleOnAction(ActionEvent actionEvent) {
        addVehicles();
    }

    private void addVehicles() {
        if (Database1.vehicleArray.size() == 14) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "You Cannot Add Vehicles!...", ButtonType.CLOSE);
            alert.setHeaderText(null);
            alert.show();
        } else {
            try {

                //System.out.println(cbxVehicleType.getValue().toString());
                //System.out.println(cbxVehicleType.getSelectionModel().getSelectedItem().toString());

                if (String.valueOf(cbxVehicleType.getSelectionModel().getSelectedItem()).equals("Van")) {
                    Van van = new Van(txtVehicleNumber.getText(), cbxVehicleType.getValue().toString(), txtMaximumWeight.getText(), Integer.parseInt(txtNoOfPassengers.getText()));

                    txtVehicleNumber.clear();
                    txtMaximumWeight.clear();
                    txtNoOfPassengers.clear();

                    if (!vehicleLabel1.getText().equals("Invalid No!") && !vehicleLabel2.getText().equals("Invalid Weight!") && !vehicleLabel3.getText().equals("Invalid Passengers!")) {
                        Database1.vehicleArray.add(van);
                        cbxVehicleType.getSelectionModel().clearSelection();
                        alert();
                    } else {
                        tryAgainAlert();
                    }
                }

                if (cbxVehicleType.getSelectionModel().getSelectedItem().toString().equals("Bus")) {
                    //System.out.println(cbxVehicleType.getValue().toString());
                    //System.out.println(cbxVehicleType.getValue());
                    Bus bus = new Bus(txtVehicleNumber.getText(), cbxVehicleType.getValue().toString(), txtMaximumWeight.getText(), Integer.parseInt(txtNoOfPassengers.getText()));

                    txtVehicleNumber.clear();
                    //cbxVehicleType.getItems().clear();
                    txtMaximumWeight.clear();
                    txtNoOfPassengers.clear();

                    if (!vehicleLabel1.getText().equals("Invalid No!") && !vehicleLabel2.getText().equals("Invalid Weight!") && !vehicleLabel3.getText().equals("Invalid Passengers!")) {
                        Database1.vehicleArray.add(bus);
                        cbxVehicleType.getSelectionModel().clearSelection();
                        alert();

                    } else {
                        tryAgainAlert();
                    }
                }
                if (cbxVehicleType.getSelectionModel().getSelectedItem().toString().equals("Cargo Lorry")) {
                    CargoLorry cargoLorry = new CargoLorry(txtVehicleNumber.getText(), cbxVehicleType.getValue().toString(), txtMaximumWeight.getText(), Integer.parseInt(txtNoOfPassengers.getText()));
                    txtVehicleNumber.clear();
                    txtMaximumWeight.clear();
                    txtNoOfPassengers.clear();

                    if (!vehicleLabel1.getText().equals("Invalid No!") && !vehicleLabel2.getText().equals("Invalid Weight!") && !vehicleLabel3.getText().equals("Invalid Passengers!")) {
                        Database1.vehicleArray.add(cargoLorry);
                        cbxVehicleType.getSelectionModel().clearSelection();
                        alert();

                    } else {
                        tryAgainAlert();
                    }
                }
            } catch (Exception e) {

            }
        }
    }

    private void tryAgainAlert(){
        Alert alert6 = new Alert(Alert.AlertType.WARNING, "Try Again...", ButtonType.CLOSE);
        alert6.setHeaderText(null);
        txtNoOfPassengers.setText(String.valueOf(0));
        alert6.show();
    }
    private void alert() {
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION, "Saved Successfully...", ButtonType.OK); //, ButtonType.CLOSE
        alert1.setHeaderText(null);
        /*Optional<ButtonType> buttonType = alert1.showAndWait();
        if (buttonType.get().equals(ButtonType.OK)) {

        } else {
            Stage stage = (Stage) addVehicleContext.getScene().getWindow();
            stage.close();
        }*/
        alert1.show();
    }

    public void checkingVehicleNo(KeyEvent keyEvent) {
        String value = "^([A-Z0-9 ]{2,3}[-]([0-9]{4}))$";
        Pattern pattern = Pattern.compile(value);
        Matcher match = pattern.matcher(txtVehicleNumber.getText());
        if (!match.matches()) {
            vehicleLabel1.setText("Invalid No!");
        } else {
            vehicleLabel1.setText("");
        }
    }

    public void checkingWeight(KeyEvent keyEvent) {
        String value = "^([0-9]{3,4})$";    // 3 ---> Minimum weight / 4 ---> Maximum weight
        Pattern pattern = Pattern.compile(value);
        Matcher match = pattern.matcher(txtMaximumWeight.getText());
        if (!match.matches()) {
            vehicleLabel2.setText("Invalid Weight!");
        } else {
            vehicleLabel2.setText("");
        }
    }

    public void checkingPassengers(KeyEvent keyEvent) {
        String value = "^([0-9]{1})$";
        if (String.valueOf(cbxVehicleType.getSelectionModel().getSelectedItem()).equals("Bus")) {
            value = "^([0-9]{1,2})$";
        }
        Pattern pattern = Pattern.compile(value);
        Matcher match = pattern.matcher(txtNoOfPassengers.getText());
        if (!match.matches()) {
            vehicleLabel3.setText("Invalid Passengers!");
        } else {
            vehicleLabel3.setText("");
        }
    }

}