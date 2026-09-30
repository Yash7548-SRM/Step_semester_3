package week8.class_problems;

import java.util.*;

class Product5 {
    String name;
    int qty;

    Product5(String name, int qty) {
        this.name = name;
        this.qty = qty;
    }
}

class Customer5 {
    String name;

    Customer5(String name) {
        this.name = name;
    }
}

interface PaymentMethod {
    boolean processPayment(double amount);
}

class CreditCardPayment implements PaymentMethod {
    @Override
    public boolean processPayment(double amount) {
        return true;
    }
}

class PayPalPayment implements PaymentMethod {
    @Override
    public boolean processPayment(double amount) {
        return false;
    }
}

class Order5 {
    Customer5 customer;
    List<Product5> items = new ArrayList<>();
    String status = "Pending";
    String orderName;

    Order5(Customer5 customer, String orderName) {
        this.customer = customer;
        this.orderName = orderName;
        System.out.println("Order created for " + customer.name);
    }

    void addProduct(Product5 product) {
        items.add(product);
    }

    void pay(PaymentMethod method, String methodName) {
        if (items.isEmpty()) {
            System.out.println("Cannot process payment for an empty order.");
            return;
        }
        System.out.println("Payment initiated via " + methodName + " for Order " + orderName);
        boolean success = method.processPayment(0);
        if (success) {
            status = "Paid";
            System.out.println("Payment for Order " + orderName + " successful. Order status: Paid");
        } else {
            System.out.println("Payment for Order " + orderName + " failed. Order status: Pending");
        }
    }
}

public class PaymentProcessingSystem {
    public static void main(String[] args) {
        Customer5 x = new Customer5("Customer X");
        Order5 orderX = new Order5(x, "X");
        orderX.addProduct(new Product5("Product A", 2));
        orderX.addProduct(new Product5("Product B", 1));
        orderX.pay(new CreditCardPayment(), "Credit Card");

        Customer5 y = new Customer5("Customer Y");
        Order5 orderY = new Order5(y, "Y");
        orderY.pay(new CreditCardPayment(), "Credit Card");

        Customer5 z = new Customer5("Customer Z");
        Order5 orderZ = new Order5(z, "Z");
        orderZ.addProduct(new Product5("Product C", 1));
        orderZ.pay(new PayPalPayment(), "PayPal");
    }
}