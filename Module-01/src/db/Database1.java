package db;

import models.*;

import java.util.ArrayList;

public class Database1 {
    public static ArrayList<Vehicle> vehicleArray = new ArrayList<>();

    static {
        vehicleArray.add(new Bus("NA-3434", "Bus", "3500 kg", 60));
        vehicleArray.add(new Van("KA-4563", "Van", "1000 kg", 7));
        vehicleArray.add(new Van("58-3567", "Van", "1500 kg", 4));
        vehicleArray.add(new Van("GF-4358", "Van", "800 kg", 4));
        vehicleArray.add(new Van("CCB-3568", "Van", "1800 kg", 8));
        vehicleArray.add(new Van("LM-6679 ", "Van", "1500 kg", 4));

        //vehicleArray.add(new Van("QA-3369", "Van", "1800 kg", 6));

        vehicleArray.add(new CargoLorry("KB-3668", "Cargo Lorry", "2500 kg", 2));
        vehicleArray.add(new CargoLorry("JJ-9878", "Cargo Lorry", "3000 kg", 2));
        vehicleArray.add(new CargoLorry("GH-5772", "Cargo Lorry", "4000 kg", 3));
        vehicleArray.add(new CargoLorry("XY-4456", "Cargo Lorry", "3500 kg", 2));
        vehicleArray.add(new CargoLorry("YQ-3536", "Cargo Lorry", "2000 kg", 2));
        vehicleArray.add(new CargoLorry("CBB-3566", "Cargo Lorry", "2500 kg", 2));

        //vehicleArray.add(new CargoLorry("QH-3444", "Cargo Lorry", "5000 kg", 4));
    }
}
