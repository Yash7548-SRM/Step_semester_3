package week4.assigment_problems;

class Payment {
    double pay(double amount) {
        System.out.println("Paid (cash): Rs " + amount);
        return amount;
    }
}

class CardPayment extends Payment {
    double payWithProcessingFee(double amount) {
        double total = amount * 1.02;
        System.out.println("Charged (card, incl. fee): Rs " + total);
        return total;
    }
}

class PaymentProcessor {
    double totalCollected = 0;

    void processTransaction(Payment payment, double amount) {
        if (payment instanceof CardPayment) {
            CardPayment cardPayment = (CardPayment) payment;
            totalCollected += cardPayment.payWithProcessingFee(amount);
        } else {
            totalCollected += payment.pay(amount);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Payment[] payments = {
            new CardPayment(),
            new Payment(),
            new CardPayment(),
            new Payment(),
            new CardPayment()
        };

        double[] amounts = {100, 50, 200, 75, 120};

        PaymentProcessor processor = new PaymentProcessor();

        for (int i = 0; i < payments.length; i++) {
            processor.processTransaction(payments[i], amounts[i]);
        }

        System.out.println("Total Collected: Rs " + processor.totalCollected);
    }
}