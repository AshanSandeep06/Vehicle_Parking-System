package controller;

import com.jfoenix.controls.JFXButton;
import db.Database1;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import models.*;
import utility.StringUtilities;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static db.Database1.vehicleArray;
import static db.Database2.driverArray;
import static javafx.util.Duration.seconds;

public class FirstInterfaceController {

    public static AnchorPane context = new AnchorPane();
    public static ArrayList<parkingDetails> parkingDetailsArrayList = new ArrayList<>();
    public static ArrayList<parkingDetails> deliveryDetailsArrayList = new ArrayList<>(); //deliveryDetails
    public static String n01 = " ";
    static int attempts = 0;
    static int attempts1 = 0;
    static Vehicle v1;
    private final boolean stop = false;

    public ComboBox<Vehicle> cmbSelectVehicle;
    public ComboBox<Driver> cmbDriver;
    public Label lblVehicleType;
    public Label lblParkingSlotNumber;
    public Label lblRealDate;
    public Label lblRealTime;
    public AnchorPane firstInterfaceContext;
    public JFXButton btnPark;
    public JFXButton btnDelivery;

    public int m = 0;
    public int n = 0;

    public int q = 0;
    public int s = 0;
    public TextField txtRealTime;
    int z = 0;

    public void initialize() {
        //txtRealTime.setStyle("-fx-text-fill: BLACK; -fx-font-size: 25px;");
        context = firstInterfaceContext;

        TimeNow();
        DateNow();

        loadAllVehicles();
        loadAllDrivers();

        lblParkingSlotNumber.setText(null);
        lblVehicleType.setText(null);

        CargoLorry.reservedSlotsOfCargoLorry.add(new Node(5, "yes"));  //5,6,7,8,9,10,11
        CargoLorry.reservedSlotsOfCargoLorry.add(new Node(6, "yes"));
        CargoLorry.reservedSlotsOfCargoLorry.add(new Node(7, "yes"));
        CargoLorry.reservedSlotsOfCargoLorry.add(new Node(8, "yes"));
        CargoLorry.reservedSlotsOfCargoLorry.add(new Node(9, "yes"));
        CargoLorry.reservedSlotsOfCargoLorry.add(new Node(10, "yes"));
        CargoLorry.reservedSlotsOfCargoLorry.add(new Node(11, "yes"));

        Van.reservedSlotsOfVan.add(new Node(1, "yes"));  //1,2,3,4,12,13
        Van.reservedSlotsOfVan.add(new Node(2, "yes"));
        Van.reservedSlotsOfVan.add(new Node(3, "yes"));
        Van.reservedSlotsOfVan.add(new Node(4, "yes"));
        Van.reservedSlotsOfVan.add(new Node(12, "yes"));
        Van.reservedSlotsOfVan.add(new Node(13, "yes"));

        Bus.reservedSlotsOfBus.add(new Node(14, "yes"));
    }

    public void loadAllVehicles() {
        ObservableList<Vehicle> observableArray = FXCollections.observableArrayList();
        for (Vehicle v1 : vehicleArray) {
            observableArray.add(v1);
        }
        cmbSelectVehicle.setItems(observableArray);
        cmbSelectVehicle.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                lblVehicleType.setText(newValue.getVehicleType());

                if (lblVehicleType.getText().equals("Bus")) {
                    for (int i = 0; i < parkingDetailsArrayList.size(); i++) {
                        if (parkingDetailsArrayList.get(i).getVehicleNumber().equals(String.valueOf(cmbSelectVehicle.getSelectionModel().getSelectedItem()))) {
                            lblParkingSlotNumber.setText(null);
                            lblParkingSlotNumber.setText(parkingDetailsArrayList.get(i).getParkingSlot());
                            btnPark.setDisable(true);
                            btnDelivery.setDisable(false);
                            return;
                        }
                    }
                } else {
                    lblParkingSlotNumber.setText(null);
                }


                // Button Disable ---> Select from comboBox and display it's Park.slotNumber & disable park btn
                if (lblVehicleType.getText().equals("Van")) {
                    for (int i = 0; i < parkingDetailsArrayList.size(); i++) {
                        if (parkingDetailsArrayList.get(i).getVehicleNumber().equals(String.valueOf(cmbSelectVehicle.getSelectionModel().getSelectedItem()))) {
                            lblParkingSlotNumber.setText(null);
                            lblParkingSlotNumber.setText(parkingDetailsArrayList.get(i).getParkingSlot());
                            btnPark.setDisable(true);
                            btnDelivery.setDisable(false);
                            return;
                        }
                    }
                }

                if (lblVehicleType.getText().equals("Cargo Lorry")) {
                    for (int i = 0; i < parkingDetailsArrayList.size(); i++) {
                        if (parkingDetailsArrayList.get(i).getVehicleNumber().equals(String.valueOf(cmbSelectVehicle.getSelectionModel().getSelectedItem()))) {
                            lblParkingSlotNumber.setText(null);
                            lblParkingSlotNumber.setText(parkingDetailsArrayList.get(i).getParkingSlot());
                            btnPark.setDisable(true);
                            btnDelivery.setDisable(false);
                            return;
                        }
                    }
                }

                // Showing a new slot number to Vans...!
                if (lblVehicleType.getText().equals("Van")) {
                    for (int i = 0; i < Van.reservedSlotsOfVan.size(); i++) {
                        if (Van.reservedSlotsOfVan.get(i).data.equals("yes")) {
                            lblParkingSlotNumber.setText(null);
                            btnPark.setDisable(false);
                            lblParkingSlotNumber.setText(String.valueOf(Van.reservedSlotsOfVan.get(i).value));
                            break;
                        }
                    }
                }

                if (lblVehicleType.getText().equals("Cargo Lorry")) {
                    for (int i = 0; i < CargoLorry.reservedSlotsOfCargoLorry.size(); i++) {
                        if (CargoLorry.reservedSlotsOfCargoLorry.get(i).data.equals("yes")) {
                            lblParkingSlotNumber.setText(null);
                            btnPark.setDisable(false);
                            lblParkingSlotNumber.setText(String.valueOf(CargoLorry.reservedSlotsOfCargoLorry.get(i).value));
                            break;
                        }
                    }
                }

                if (lblVehicleType.getText().equals("Bus")) {
                    for (int i = 0; i < Bus.reservedSlotsOfBus.size(); i++) {
                        if (Bus.reservedSlotsOfBus.get(i).data.equals("yes")) {
                            lblParkingSlotNumber.setText(null);
                            btnPark.setDisable(false);
                            lblParkingSlotNumber.setText(String.valueOf(Bus.reservedSlotsOfBus.get(i).value));
                            break;
                        }
                    }
                }


                if (lblVehicleType.getText().equals("Bus")) {
                    for (int i = 0; i < deliveryDetailsArrayList.size(); i++) {
                        if (deliveryDetailsArrayList.get(i).getVehicleNumber().equals(String.valueOf(cmbSelectVehicle.getSelectionModel().getSelectedItem()))) {
                            btnPark.setDisable(false);
                            btnDelivery.setDisable(true);
                            return;
                        }
                    }
                }

                //Button Disable ---> Select from comboBox and display it's Park.slotNumber & disable Delivery btn
                if (lblVehicleType.getText().equals("Van")) {
                    for (int i = 0; i < deliveryDetailsArrayList.size(); i++) {
                        if (deliveryDetailsArrayList.get(i).getVehicleNumber().equals(String.valueOf(cmbSelectVehicle.getSelectionModel().getSelectedItem()))) {
                            btnPark.setDisable(false);
                            btnDelivery.setDisable(true);
                            return;
                        }
                    }
                }


                if (lblVehicleType.getText().equals("Cargo Lorry")) {
                    for (int i = 0; i < deliveryDetailsArrayList.size(); i++) {
                        if (deliveryDetailsArrayList.get(i).getVehicleNumber().equals(String.valueOf(cmbSelectVehicle.getSelectionModel().getSelectedItem()))) {
                            btnDelivery.setDisable(true);
                            btnPark.setDisable(false);
                            return;
                        }
                    }
                }
            }

            // ----> Vehicle is parked therefore, delivery btn should be enabled...!
            btnDelivery.setDisable(false);
            if (lblVehicleType.getText().equals("Van")) {
                for (int i = 0; i < Van.reservedSlotsOfVan.size(); i++) {
                    if (Van.reservedSlotsOfVan.get(i).data.equals("no")) {
                        btnDelivery.setDisable(false);
                        break;
                    }
                }
            }

            if (lblVehicleType.getText().equals("Cargo Lorry")) {
                for (int i = 0; i < CargoLorry.reservedSlotsOfCargoLorry.size(); i++) {
                    if (CargoLorry.reservedSlotsOfCargoLorry.get(i).data.equals("no")) {
                        btnDelivery.setDisable(false);
                        break;
                    }
                }
            }

            if (lblVehicleType.getText().equals("Bus")) {
                for (int i = 0; i < Bus.reservedSlotsOfBus.size(); i++) {
                    if (Bus.reservedSlotsOfBus.get(i).data.equals("no")) {
                        btnDelivery.setDisable(false);
                        break;
                    }
                }
            }


        });
    }

    public void loadAllDrivers() {
        ObservableList<Driver> obList = FXCollections.observableArrayList();
        for (Driver d1 : driverArray) {
            obList.add(d1);
        }
        cmbDriver.setItems(obList);
        cmbDriver.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

        });
    }

    public void parkVehicleOnAction(ActionEvent event) {
        if (String.valueOf(cmbSelectVehicle.getSelectionModel().getSelectedItem()) != null && lblVehicleType.getText() != null) {
            int j = 0;

            if (lblVehicleType.getText().equals("Bus")) {
                parkingDetails p1 = new parkingDetails(String.valueOf(cmbSelectVehicle.getSelectionModel().getSelectedItem()));
                if (!parkingDetailsArrayList.contains(p1)) {
                    if (Bus.reservedSlotsOfBus.get(0).data.equals("yes")) {
                        Bus.reservedSlotsOfBus.get(0).data = "no";
                        p1 = new parkingDetails(String.valueOf(cmbSelectVehicle.getSelectionModel().getSelectedItem()), lblVehicleType.getText(), String.valueOf(cmbDriver.getSelectionModel().getSelectedItem()), lblParkingSlotNumber.getText(), lblRealDate.getText() + " -" + lblRealTime.getText());
                        parkingDetailsArrayList.add(p1);
                    }
                }
            }

            if (lblVehicleType.getText().equals("Van")) {
                parkingDetails p1 = new parkingDetails(String.valueOf(cmbSelectVehicle.getSelectionModel().getSelectedItem()));
                if (!parkingDetailsArrayList.contains(p1)) {
                    for (int i = 0; i < Van.reservedSlotsOfVan.size(); i++) {
                        if (Van.reservedSlotsOfVan.get(i).data.equals("yes")) {
                            Van.reservedSlotsOfVan.get(i).data = "no";
                            p1 = new parkingDetails(String.valueOf(cmbSelectVehicle.getSelectionModel().getSelectedItem()), lblVehicleType.getText(), String.valueOf(cmbDriver.getSelectionModel().getSelectedItem()), lblParkingSlotNumber.getText(), lblRealDate.getText() + " -" + lblRealTime.getText());
                            parkingDetailsArrayList.add(p1);
                            return;
                        }
                    }
                }
            }

            if (lblVehicleType.getText().equals("Cargo Lorry")) {
                parkingDetails p1 = new parkingDetails(String.valueOf(cmbSelectVehicle.getSelectionModel().getSelectedItem()));
                if (!parkingDetailsArrayList.contains(p1)) {
                    for (int i = 0; i < CargoLorry.reservedSlotsOfCargoLorry.size(); i++) {
                        if (CargoLorry.reservedSlotsOfCargoLorry.get(i).data.equals("yes")) {
                            CargoLorry.reservedSlotsOfCargoLorry.get(i).data = "no";
                            p1 = new parkingDetails(String.valueOf(cmbSelectVehicle.getSelectionModel().getSelectedItem()), lblVehicleType.getText(), String.valueOf(cmbDriver.getSelectionModel().getSelectedItem()), lblParkingSlotNumber.getText(), lblRealDate.getText() + " -" + lblRealTime.getText());
                            parkingDetailsArrayList.add(p1);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void onDeliveryShiftOnAction(ActionEvent event) {
        if (lblVehicleType.getText().equals("Bus")) {
            parkingDetails p1 = new parkingDetails(String.valueOf(cmbSelectVehicle.getSelectionModel().getSelectedItem()));
            p1 = new parkingDetails(String.valueOf(cmbSelectVehicle.getSelectionModel().getSelectedItem()), lblVehicleType.getText(), String.valueOf(cmbDriver.getSelectionModel().getSelectedItem()), lblParkingSlotNumber.getText(), lblRealDate.getText() + " -" + lblRealTime.getText());
            if (parkingDetailsArrayList.contains(p1)) {
                if (Bus.reservedSlotsOfBus.get(0).data.equals("no")) {
                    Bus.reservedSlotsOfBus.get(0).data = "yes";
                    deliveryDetailsArrayList.add(p1);
                    parkingDetailsArrayList.remove(p1);
                }
            }
        }

        if (lblVehicleType.getText().equals("Van")) {
            parkingDetails p1 = new parkingDetails(String.valueOf(cmbSelectVehicle.getSelectionModel().getSelectedItem()));
            p1 = new parkingDetails(String.valueOf(cmbSelectVehicle.getSelectionModel().getSelectedItem()), lblVehicleType.getText(), String.valueOf(cmbDriver.getSelectionModel().getSelectedItem()), lblParkingSlotNumber.getText(), lblRealDate.getText() + " -" + lblRealTime.getText());
            if (parkingDetailsArrayList.contains(p1)) {
                for (int i = 0; i < Van.reservedSlotsOfVan.size(); i++) {
                    if (lblParkingSlotNumber.getText().equals(String.valueOf(Van.reservedSlotsOfVan.get(i).value)) && Van.reservedSlotsOfVan.get(i).data.equals("no")) {
                        Van.reservedSlotsOfVan.get(i).data = "yes";
                        deliveryDetailsArrayList.add(p1);
                        parkingDetailsArrayList.remove(p1);
                    }
                }
            }
        }

        if (lblVehicleType.getText().equals("Cargo Lorry")) {
            parkingDetails p1 = new parkingDetails(String.valueOf(cmbSelectVehicle.getSelectionModel().getSelectedItem()));
            p1 = new parkingDetails(String.valueOf(cmbSelectVehicle.getSelectionModel().getSelectedItem()), lblVehicleType.getText(), String.valueOf(cmbDriver.getSelectionModel().getSelectedItem()), lblParkingSlotNumber.getText(), lblRealDate.getText() + " -" + lblRealTime.getText());
            if (parkingDetailsArrayList.contains(p1)) {
                for (int i = 0; i < CargoLorry.reservedSlotsOfCargoLorry.size(); i++) {
                    if (lblParkingSlotNumber.getText().equals(String.valueOf(CargoLorry.reservedSlotsOfCargoLorry.get(i).value)) && CargoLorry.reservedSlotsOfCargoLorry.get(i).data.equals("no")) {
                        CargoLorry.reservedSlotsOfCargoLorry.get(i).data = "yes";
                        deliveryDetailsArrayList.add(p1);
                        parkingDetailsArrayList.remove(p1);
                    }
                }
            }
        }
    }

    public void managementLogInOnAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/loginOptionPane.fxml"))));
        stage.setResizable(false);
        stage.setTitle("Log In");
        stage.show();
    }

    private void TimeNow() {

       Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);

        Thread thread = new Thread(() -> {
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
            while (!stop) {
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    System.out.println(e);
                }
                final String timeNow = sdf.format(new Date());
                Platform.runLater(() -> {    //FX Application wala thread ekak ---> Java Fx wala
                    if (hour >= 12) {
                        lblRealTime.setText(timeNow + " PM");
                    } else {
                        lblRealTime.setText(timeNow + " AM");
                    }

                });
            }
        });
        thread.start();

        /*DateTimeFormatter SHORT_TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0),
                event -> lblRealTime.setText(LocalTime.now().format(SHORT_TIME_FORMATTER))),
                new KeyFrame(Duration.seconds(1)));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();*/

        //SSSSSSSSSSSSSSSSSSSSSSSSS


       /*Timeline timeline = new Timeline(
                new KeyFrame(seconds(0),
                        new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                Calendar time = Calendar.getInstance();
                                String hourString = StringUtilities.pad(2, ' ', time.get(Calendar.HOUR) == 0 ? "12" : time.get(Calendar.HOUR) + "");
                                String minuteString = StringUtilities.pad(2, '0', time.get(Calendar.MINUTE) + "");
                                String secondString = StringUtilities.pad(2, '0', time.get(Calendar.SECOND) + "");
                                String ampmString = time.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";
                                lblRealTime.setText(hourString + ":" + minuteString + ":" + secondString + " " + ampmString);
                            }
                        }
                ),
                new KeyFrame(seconds(1))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();*/





       /* Thread clock = new Thread() {
            public void run() {
                for (; ; ) {
                    DateFormat dateFormat = new SimpleDateFormat("hh:mm ");
                    Calendar cal = Calendar.getInstance();

                    int minute = cal.get(Calendar.MINUTE);
                    int hour = cal.get(Calendar.HOUR_OF_DAY);

                    try {
                        String state = null;
                        if (hour >= 12) {
                            state = "PM";
                        } else {
                            state = "AM";
                        }
                        lblRealTime.setText("" + String.format("%02d", hour) + ":" + String.format("%02d", minute) + " " + state);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            System.out.println(ex);
                        }
                    } catch (NullPointerException e) {
                        System.out.println(e);
                    }
                }
            }
        };
        clock.start();

*/
       /* Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);

        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();

            int minute = currentTime.getMinute();
            int hour1 = currentTime.getHour();
            int seconds = currentTime.getSecond();

            String x;
            String y;
            String z;
            String a;
            if(hour1<10){
                z=0+""+currentTime.getHour();
            }else{
                z=String.valueOf(currentTime.getHour());
            }
            if(minute<10){
                x=0+""+currentTime.getMinute();
            }else{
                x=String.valueOf(currentTime.getMinute());
            }
            if(seconds<10){
                //a=0+""+currentTime.getSecond();
                a="0"+seconds;
                System.out.println(a);
            }else{
                a=String.valueOf(currentTime.getSecond());
            }
            if (hour >= 12) {
                y="PM";
            } else {
                y="AM";
            }

            lblRealTime.setText(Integer.parseInt(z) + ":" +
                    Integer.parseInt(x) + ":" +
                    Integer.parseInt(a)+" "+y);
        }),
                // second eken second ekata iterate wenna
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();*/
    }

    private void DateNow() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dateNow = sdf.format(new Date());
        lblRealDate.setText(dateNow);
    }

}


