package week10.class_problems;

public class PayrollRegisterSystem {

    static abstract class Staff {
        String name;
        String type;

        Staff(String name, String type) {
            this.name = name;
            this.type = type;
        }

        abstract int calculatePay();

        @Override
        public String toString() {
            return "Payslip[name=" + name + ", type=" + type + ", pay=" + calculatePay() + "]";
        }
    }

    static class FullTime extends Staff {
        int salary;

        FullTime(String name, int salary) {
            super(name, "FullTime");
            this.salary = salary;
        }

        int calculatePay() {
            return salary;
        }
    }

    static class PartTime extends Staff {
        int hours;
        int rate;

        PartTime(String name, int hours, int rate) {
            super(name, "PartTime");
            this.hours = hours;
            this.rate = rate;
        }

        int calculatePay() {
            return hours * rate;
        }
    }

    static class Intern extends Staff {
        int stipend;

        Intern(String name, int stipend) {
            super(name, "Intern");
            this.stipend = stipend;
        }

        int calculatePay() {
            return stipend;
        }
    }

    public static void main(String[] args) {
        String[] lines = {
            "FullTime Asha 50000",
            "PartTime Ravi 80 300",
            "Intern Neha 15000"
        };

        Staff[] staff = new Staff[lines.length];

        for (int i = 0; i < lines.length; i++) {
            String[] p = lines[i].split(" ");
            if (p[0].equals("FullTime")) {
                staff[i] = new FullTime(p[1], Integer.parseInt(p[2]));
            } else if (p[0].equals("PartTime")) {
                staff[i] = new PartTime(p[1], Integer.parseInt(p[2]), Integer.parseInt(p[3]));
            } else {
                staff[i] = new Intern(p[1], Integer.parseInt(p[2]));
            }
        }

        int total = 0;
        Staff top = staff[0];
        for (Staff s : staff) {
            System.out.println(s);
            total += s.calculatePay();
            if (s.calculatePay() > top.calculatePay()) top = s;
        }

        System.out.println("Total " + total);
        System.out.println("top earner " + top.name);
    }
}