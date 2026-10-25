package week10.class_problems;

import java.util.HashMap;

public class BankWithdrawalSystem {

    static abstract class Account {
        String id;
        int balance;

        Account(String id, int balance) {
            this.id = id;
            this.balance = balance;
        }

        abstract int lowestAllowedBalance();
        abstract String rejectionReason();

        String withdraw(int amount) {
            if (balance - amount < lowestAllowedBalance()) {
                return id + " rejected: " + rejectionReason();
            }
            balance -= amount;
            return id + " balance " + balance;
        }
    }

    static class SavingsAccount extends Account {
        SavingsAccount(String id, int balance) {
            super(id, balance);
        }

        int lowestAllowedBalance() {
            return 1000;
        }

        String rejectionReason() {
            return "minimum balance 1000";
        }
    }

    static class CurrentAccount extends Account {
        CurrentAccount(String id, int balance) {
            super(id, balance);
        }

        int lowestAllowedBalance() {
            return -5000;
        }

        String rejectionReason() {
            return "overdraft limit 5000";
        }
    }

    public static void main(String[] args) {
        String[] lines = {
            "Savings S1 5000",
            "WITHDRAW S1 4500",
            "Current C1 2000",
            "WITHDRAW C1 6000",
            "WITHDRAW S1 3000",
            "WITHDRAW C1 2000"
        };

        HashMap<String, Account> accounts = new HashMap<>();

        for (String line : lines) {
            String[] p = line.split(" ");
            if (p[0].equals("Savings")) {
                accounts.put(p[1], new SavingsAccount(p[1], Integer.parseInt(p[2])));
            } else if (p[0].equals("Current")) {
                accounts.put(p[1], new CurrentAccount(p[1], Integer.parseInt(p[2])));
            } else if (p[0].equals("WITHDRAW")) {
                Account acc = accounts.get(p[1]);
                if (acc == null) {
                    System.out.println("Account not found");
                } else {
                    System.out.println(acc.withdraw(Integer.parseInt(p[2])));
                }
            }
        }
    }
}