package week10.class_problems;

import java.util.HashMap;

public class CampusVehiclePassSystem {

    interface Chargeable {
    }

    static abstract class Vehicle {
        String passNumber;
        String owner;
        String type;

        Vehicle(String type, String passNumber, String owner) {
            this.type = type;
            this.passNumber = passNumber;
            this.owner = owner;
        }

        abstract int passFee();
    }

    static class Bike extends Vehicle {
        Bike(String type, String passNumber, String owner) {
            super(type, passNumber, owner);
        }

        int passFee() {
            return 300;
        }
    }

    static class Car extends Vehicle {
        Car(String type, String passNumber, String owner) {
            super(type, passNumber, owner);
        }

        int passFee() {
            return 1000;
        }
    }

    static class EBike extends Bike implements Chargeable {
        EBike(String type, String passNumber, String owner) {
            super(type, passNumber, owner);
        }
    }

    static class ECar extends Car implements Chargeable {
        ECar(String type, String passNumber, String owner) {
            super(type, passNumber, owner);
        }
    }

    static Vehicle createVehicle(String type, String pass, String owner) {
        switch (type) {
            case "Bike": return new Bike(type, pass, owner);
            case "Car": return new Car(type, pass, owner);
            case "EBike":
            case "E-Bike": return new EBike(type, pass, owner);
            case "ECar":
            case "E-Car": return new ECar(type, pass, owner);
            default: return null;
        }
    }

    public static void main(String[] args) {
        String[] lines = {
            "PASS Bike KA01 Asha",
            "PASS ECar KA02 Ravi",
            "CHARGE KA02",
            "CHARGE KA01"
        };

        HashMap<String, Vehicle> vehicles = new HashMap<>();

        for (String line : lines) {
            String[] p = line.split(" ");
            if (p[0].equals("PASS")) {
                Vehicle v = createVehicle(p[1], p[2], p[3]);
                if (v == null) {
                    System.out.println("Unknown vehicle type");
                    continue;
                }
                vehicles.put(p[2], v);
                System.out.println(v.passNumber + " (" + v.type + ") pass fee " + v.passFee());
            } else if (p[0].equals("CHARGE")) {
                Vehicle v = vehicles.get(p[1]);
                if (v == null) {
                    System.out.println(p[1] + " not found");
                } else if (v instanceof Chargeable) {
                    System.out.println(v.passNumber + " charging bay allotted");
                } else {
                    System.out.println(v.passNumber + " rejected: charging unsupported");
                }
            }
        }
    }
}