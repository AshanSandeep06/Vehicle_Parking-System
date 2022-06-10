package db;

import models.Bus;
import models.CargoLorry;
import models.Driver;
import models.Van;

import java.util.ArrayList;

public class Database2 {
    public static ArrayList<Driver> driverArray = new ArrayList<>();

    static {
        driverArray.add(new Driver("Sumith Kumara", "7835348345V", "B6474845", "Panadura","0725637456"));
        driverArray.add(new Driver("Amila Pathirana", "8826253734V", "B3354674", "Galle","0717573583"));
        driverArray.add(new Driver("Jithmal Perera", "9283289272V", "B3674589", "Horana","0772452457"));
        driverArray.add(new Driver("Sumith Dissanayaka", "9425245373V", "B8366399", "Kaluthara","0782686390"));
        driverArray.add(new Driver("Sumanasiri Herath", "8976544373V", "B3537538", "Beruwala","0772534436"));
        driverArray.add(new Driver("Awantha Fernando ", "9173537839V", "B3554789", "Colombo 5","0714534356"));
        driverArray.add(new Driver("Charith Sudara", "9573536833V", "B6835836", "Baththaramulla","0771536662"));
        driverArray.add(new Driver("Prashan Dineth", "9362426738V", "B2683536", "Wadduwa","0715353434"));
        driverArray.add(new Driver("Chethiya Dilan", "9162353436V", "B6836836", "Panadura","0772436737"));
        driverArray.add(new Driver("Dushantha Perera", "9255556343V", "B3334435", "Matara","0777245343"));
        driverArray.add(new Driver("Sumith Udayanga", "8735354355V", "B3573783", "Galle","0703635442"));
        driverArray.add(new Driver("Dinesh Udara", "8735354355V", "B5343783", "Hettimulla","0713456878"));
        driverArray.add(new Driver("Udana Chathurangaa", "9692653338V", "B5343783", "Kottawa","0772442444"));
        driverArray.add(new Driver("Mohommad Riaz", "9124537733V", "B3638537", "Kaluthara","0777544222"));
        //driverArray.add(new Driver("Sandun Kumara", "9563524267V", "B2263333", "Panadura","0772325544"));
        //driverArray.add(new Driver("Priyanga Perera", "Cargo Lorry", "2500 kg", 2));
    }
}
