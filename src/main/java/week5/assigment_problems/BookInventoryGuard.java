package week5.assigment_problems;

class BookInventoryGuard {
    private int copiesTotal;
    private int copiesAvailable;

    BookInventoryGuard(int copiesTotal) {
        this.copiesTotal = copiesTotal;
        this.copiesAvailable = copiesTotal;
    }

    void checkOut() {
        if (copiesAvailable <= 0) return;
        copiesAvailable--;
    }

    void checkIn() {
        if (copiesAvailable >= copiesTotal) return;
        copiesAvailable++;
    }

    int getCopiesAvailable() {
        return copiesAvailable;
    }
}

public class BookInventoryGuardDemo {
    public static void main(String[] args) {
        BookInventoryGuard b = new BookInventoryGuard(3);
        b.checkOut();
        b.checkOut();
        b.checkOut();
        b.checkOut();
        System.out.println(b.getCopiesAvailable());

        BookInventoryGuard b2 = new BookInventoryGuard(3);
        b2.checkOut();
        b2.checkOut();
        b2.checkOut();
        b2.checkIn();
        b2.checkIn();
        b2.checkIn();
        b2.checkIn();
        System.out.println(b2.getCopiesAvailable());
    }
}