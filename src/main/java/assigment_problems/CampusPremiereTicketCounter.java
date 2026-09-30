package week8.assigment_problems;

import java.util.*;

abstract class Seat3 {
    String seatId;

    Seat3(String seatId) {
        this.seatId = seatId;
    }

    abstract double getPrice();
}

class RegularSeat extends Seat3 {
    RegularSeat(String seatId) {
        super(seatId);
    }

    @Override
    double getPrice() {
        return 150;
    }
}

class PremiumSeat extends Seat3 {
    PremiumSeat(String seatId) {
        super(seatId);
    }

    @Override
    double getPrice() {
        return 250;
    }
}

class ReclinerSeat extends Seat3 {
    ReclinerSeat(String seatId) {
        super(seatId);
    }

    @Override
    double getPrice() {
        return 400;
    }
}

class Customer3 {
    String name;

    Customer3(String name) {
        this.name = name;
    }
}

class Show {
    String name;
    Set<String> bookedSeatIds = new HashSet<>();

    Show(String name) {
        this.name = name;
    }

    boolean isBooked(Seat3 seat) {
        return bookedSeatIds.contains(seat.seatId);
    }
}

class Booking {
    Customer3 customer;
    Show show;
    List<Seat3> seats;
    boolean active = true;

    Booking(Customer3 customer, Show show, List<Seat3> seats) {
        this.customer = customer;
        this.show = show;
        this.seats = seats;
    }
}

class TicketCounter {
    Booking book(Customer3 customer, Show show, List<Seat3> seats) {
        for (Seat3 seat : seats) {
            if (show.isBooked(seat)) {
                System.out.println("Seat " + seat.seatId + " is already booked for this show.");
                return null;
            }
        }
        double total = 0;
        StringBuilder seatList = new StringBuilder();
        for (int i = 0; i < seats.size(); i++) {
            Seat3 seat = seats.get(i);
            show.bookedSeatIds.add(seat.seatId);
            total += seat.getPrice();
            seatList.append(seat.seatId);
            if (i != seats.size() - 1) seatList.append(", ");
        }
        System.out.println("Booking confirmed for " + customer.name + ": " + seatList + ". Total: ₹" + String.format("%.2f", total));
        return new Booking(customer, show, seats);
    }

    void cancel(Booking booking, boolean showStarted) {
        if (showStarted) {
            System.out.println("Cannot cancel: show has already started.");
            return;
        }
        booking.active = false;
        StringBuilder seatList = new StringBuilder();
        for (int i = 0; i < booking.seats.size(); i++) {
            Seat3 seat = booking.seats.get(i);
            booking.show.bookedSeatIds.remove(seat.seatId);
            seatList.append(seat.seatId);
            if (i != booking.seats.size() - 1) seatList.append(", ");
        }
        System.out.println(booking.customer.name + "'s booking cancelled. Seats " + seatList + " released.");
    }
}

public class CampusPremiereTicketCounter {
    public static void main(String[] args) {
        TicketCounter counter = new TicketCounter();
        Show show = new Show("7 PM show");

        Customer3 asha = new Customer3("Asha");
        Customer3 ravi = new Customer3("Ravi");
        Customer3 neha = new Customer3("Neha");

        RegularSeat a1 = new RegularSeat("A1");
        RegularSeat a2 = new RegularSeat("A2");
        PremiumSeat f5 = new PremiumSeat("F5");
        ReclinerSeat r1 = new ReclinerSeat("R1");

        Booking ashaBooking = counter.book(asha, show, Arrays.asList(a1, a2, f5));
        counter.book(ravi, show, Arrays.asList(a2));
        counter.book(ravi, show, Arrays.asList(r1));
        counter.cancel(ashaBooking, false);
        counter.book(neha, show, Arrays.asList(a2));
    }
}