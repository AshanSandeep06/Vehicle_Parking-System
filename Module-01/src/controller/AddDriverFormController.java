package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import db.Database2;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Driver;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddDriverFormController {

    public AnchorPane addDriverContext;
    public TextField txtDriverName;
    public TextField txtNIC;
    public TextField txtLicenseNO;
    public TextField txtAddress;
    public TextField txtContactNumber;
    public Label driverLabel1;
    public Label driverLabel2;
    public Label driverLabel3;
    public Label driverLabel4;

    public void addDriverOnAction(ActionEvent actionEvent) throws IOException {
        addDriver();
    }

    private void addDriver() throws IOException {
        try {
            Driver driver = new Driver(txtDriverName.getText(), txtNIC.getText(), txtLicenseNO.getText(), txtAddress.getText(), txtContactNumber.getText());

            txtDriverName.clear();
            txtNIC.clear();
            txtLicenseNO.clear();
            txtAddress.clear();
            txtContactNumber.clear();

            if (!driverLabel1.getText().equals("Invalid Name!") && !driverLabel2.getText().equals("Invalid NIC!") && !driverLabel3.getText().equals("Invalid Licence No!") && !driverLabel4.getText().equals("Invalid Contact!")) {
                Database2.driverArray.add(driver);

                Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION, "Saved Successfully...", ButtonType.CLOSE, ButtonType.OK);
                alert1.setHeaderText(null);
                Optional<ButtonType> buttonType = alert1.showAndWait();
                if (buttonType.get().equals(ButtonType.OK)) {

                } else {
                    Stage stage = (Stage) addDriverContext.getScene().getWindow();
                    stage.close();
                }
            } else {
                Alert alert2 = new Alert(Alert.AlertType.WARNING, "Try Again...", ButtonType.CLOSE);
                alert2.setHeaderText(null);
                alert2.show();
            }
        } catch (NumberFormatException e) {

        }
    }

    private void enableAddDriverButton() {
        try {
            if (txtDriverName.getText().equals("") || txtNIC.getText().equals("") || txtLicenseNO.getText().equals("") || txtAddress.getText().equals("") || txtContactNumber.getText().equals("")) {
                Alert alert2 = new Alert(Alert.AlertType.WARNING, "Try Again...", ButtonType.CLOSE);
                alert2.setHeaderText(null);
                alert2.show();
                return;
            }
        } catch (NullPointerException e) {

        }
    }

    public void checkingDriverName(KeyEvent keyEvent) {
        String value = "^([A-Z a-z]{5,20})$";
        Pattern pattern = Pattern.compile(value);
        Matcher match = pattern.matcher(txtDriverName.getText());
        if (!match.matches()) {
            driverLabel1.setText("Invalid Name!");
        } else {
            driverLabel1.setText("");
        }
    }

    public void checkingNIC(KeyEvent keyEvent) {
        String value = "^([0-9]{9}.([V]{1}))$";
        Pattern pattern = Pattern.compile(value);
        Matcher match = pattern.matcher(txtNIC.getText());
        if (!match.matches()) {
            driverLabel2.setText("Invalid NIC!");
        } else {
            driverLabel2.setText("");
        }
    }

    public void checkingDrivingLicense(KeyEvent keyEvent) {
        String value = "^([B]{1}.([0-9]{6}))$";
        Pattern pattern = Pattern.compile(value);
        Matcher match = pattern.matcher(txtLicenseNO.getText());
        if (!match.matches()) {
            driverLabel3.setText("Invalid Licence No!");
        } else {
            driverLabel3.setText("");
        }
    }

    public void checkingContactNo(KeyEvent keyEvent) {
        String value = "^([0-9]{10})$";
        Pattern pattern = Pattern.compile(value);
        Matcher match = pattern.matcher(txtContactNumber.getText());
        if (!match.matches()) {
            driverLabel4.setText("Invalid Contact!");
        } else {
            driverLabel4.setText("");
        }
    }

}