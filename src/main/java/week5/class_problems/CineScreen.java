package week5.class_problems;

class CineScreen {
    private int seatsTotal;
    private int seatsAvailable;

    CineScreen(int seatsTotal) {
        if (seatsTotal <= 0) {
            throw new IllegalArgumentException("construction rejected");
        }
        this.seatsTotal = seatsTotal;
        this.seatsAvailable = seatsTotal;
    }

    void bookSeat() {
        if (seatsAvailable <= 0) return;
        seatsAvailable--;
    }

    void cancelBooking() {
        if (seatsAvailable >= seatsTotal) return;
        seatsAvailable++;
    }

    int getSeatsAvailable() {
        return seatsAvailable;
    }
}

public class CineScreenDemo {
    public static void main(String[] args) {
        CineScreen c = new CineScreen(2);
        c.bookSeat();
        c.bookSeat();
        c.bookSeat();
        System.out.println(c.getSeatsAvailable());

        c.cancelBooking();
        c.cancelBooking();
        c.cancelBooking();
        System.out.println(c.getSeatsAvailable());
    }
}