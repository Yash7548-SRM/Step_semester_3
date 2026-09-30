package week8.class_problems;

import java.util.*;

abstract class Room4 {
    String roomId;
    List<Reservation> reservations = new ArrayList<>();

    Room4(String roomId) {
        this.roomId = roomId;
    }

    abstract double calculatePrice(int days);

    boolean isAvailable(int startDay, int endDay) {
        for (Reservation r : reservations) {
            if (r.active && startDay < r.endDay && endDay > r.startDay) {
                return false;
            }
        }
        return true;
    }
}

class StandardRoom extends Room4 {
    StandardRoom(String roomId) {
        super(roomId);
    }

    @Override
    double calculatePrice(int days) {
        return days * 100;
    }
}

class DeluxeRoom extends Room4 {
    DeluxeRoom(String roomId) {
        super(roomId);
    }

    @Override
    double calculatePrice(int days) {
        return days * 180;
    }
}

class Customer4 {
    String name;

    Customer4(String name) {
        this.name = name;
    }
}

class Reservation {
    Room4 room;
    Customer4 customer;
    int startDay;
    int endDay;
    boolean active = true;

    Reservation(Room4 room, Customer4 customer, int startDay, int endDay) {
        this.room = room;
        this.customer = customer;
        this.startDay = startDay;
        this.endDay = endDay;
    }
}

class HotelSystem {
    Reservation reserve(Room4 room, Customer4 customer, int startDay, int endDay) {
        if (!room.isAvailable(startDay, endDay)) {
            System.out.println(room.roomId + " is not available from Day " + startDay + " to Day " + endDay);
            return null;
        }
        int days = endDay - startDay;
        Reservation res = new Reservation(room, customer, startDay, endDay);
        room.reservations.add(res);
        double price = room.calculatePrice(days);
        System.out.println("Reservation confirmed for " + customer.name + ", " + room.roomId + ". Price: $" + price);
        return res;
    }

    void cancel(Reservation res, int currentDay, int deadlineDay) {
        if (currentDay > deadlineDay) {
            System.out.println("Cancellation deadline passed for " + res.room.roomId);
            return;
        }
        res.active = false;
        System.out.println("Reservation for " + res.customer.name + ", " + res.room.roomId + " cancelled successfully.");
    }
}

public class HotelBookingSystem {
    public static void main(String[] args) {
        HotelSystem hotel = new HotelSystem();
        StandardRoom room101 = new StandardRoom("Standard Room 101");
        DeluxeRoom room201 = new DeluxeRoom("Deluxe Room 201");

        Customer4 a = new Customer4("Customer A");
        Customer4 b = new Customer4("Customer B");
        Customer4 c = new Customer4("Customer C");

        System.out.println(room101.roomId + " available: " + room101.isAvailable(1, 5));
        Reservation resA = hotel.reserve(room101, a, 1, 5);
        hotel.reserve(room101, b, 3, 7);
        hotel.cancel(resA, 1, 10);
        hotel.reserve(room201, c, 40, 42);
    }
}