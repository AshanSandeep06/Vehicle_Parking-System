package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;

public class LoginOptionPaneController {

    public static String userName, password;
    public AnchorPane loginOptionPaneContext;
    public TextField txtUserName;
    public PasswordField txtPassword;

    public void initialize() {
        userName = "admin";
        password = "123";
    }

    public void cancelOnAction(ActionEvent event) {
        txtUserName.setText(null);
        txtPassword.setText(null);
    }

    public void loginOnAction(ActionEvent event) throws IOException {
        if (txtUserName.getText().equals(userName) && txtPassword.getText().equals(password)) {
            Stage window = (Stage) loginOptionPaneContext.getScene().getWindow();
            window.close();

            Stage stage = (Stage) FirstInterfaceController.context.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/managementUserInterface.fxml"))));
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid username or password");
            alert.show();
        }
    }
}
