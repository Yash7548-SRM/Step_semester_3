package week8.class_problems;

import java.util.*;

abstract class Vehicle1 {
    String vehicleId;
    boolean available = true;

    Vehicle1(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    abstract double calculateCharge(int days);
}

class Sedan extends Vehicle1 {
    Sedan(String vehicleId) {
        super(vehicleId);
    }

    @Override
    double calculateCharge(int days) {
        return days * 50;
    }
}

class SUV extends Vehicle1 {
    SUV(String vehicleId) {
        super(vehicleId);
    }

    @Override
    double calculateCharge(int days) {
        return days * 80;
    }
}

class Customer1 {
    String name;

    Customer1(String name) {
        this.name = name;
    }
}

class Rental1 {
    Vehicle1 vehicle;
    Customer1 customer;
    int days;

    Rental1(Vehicle1 vehicle, Customer1 customer, int days) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.days = days;
    }
}

class RentalSystem {
    List<Rental1> activeRentals = new ArrayList<>();

    Rental1 rentVehicle(Vehicle1 vehicle, Customer1 customer, int days) {
        if (!vehicle.available) {
            System.out.println(vehicle.vehicleId + " is currently unavailable.");
            return null;
        }
        vehicle.available = false;
        Rental1 rental = new Rental1(vehicle, customer, days);
        activeRentals.add(rental);
        double charge = vehicle.calculateCharge(days);
        System.out.println(vehicle.vehicleId + " rented successfully by " + customer.name + ". Rental charge: $" + charge);
        return rental;
    }

    void returnVehicle(Rental1 rental) {
        rental.vehicle.available = true;
        activeRentals.remove(rental);
        System.out.println(rental.vehicle.vehicleId + " returned by " + rental.customer.name);
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        RentalSystem system = new RentalSystem();
        Sedan sedanA = new Sedan("Sedan A");
        SUV suvB = new SUV("SUV B");

        Customer1 c1 = new Customer1("Customer 1");
        Customer1 c2 = new Customer1("Customer 2");
        Customer1 c3 = new Customer1("Customer 3");

        Rental1 r1 = system.rentVehicle(sedanA, c1, 3);
        system.rentVehicle(sedanA, c2, 2);
        system.returnVehicle(r1);
        system.rentVehicle(suvB, c3, 5);
    }
}