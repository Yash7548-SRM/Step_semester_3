package week8.assigment_problems;

abstract class WashType {
    abstract int getDuration();
    abstract double getCharge();
    abstract String getName();
}

class QuickWash extends WashType {
    int getDuration() { return 30; }
    double getCharge() { return 20; }
    String getName() { return "Quick"; }
}

class NormalWash extends WashType {
    int getDuration() { return 45; }
    double getCharge() { return 30; }
    String getName() { return "Normal"; }
}

class HeavyWash extends WashType {
    int getDuration() { return 60; }
    double getCharge() { return 45; }
    String getName() { return "Heavy"; }
}

class Student1 {
    String name;

    Student1(String name) {
        this.name = name;
    }
}

class WashCycle {
    Student1 student;
    WashType washType;

    WashCycle(Student1 student, WashType washType) {
        this.student = student;
        this.washType = washType;
    }
}

class WashingMachine {
    String machineId;
    private boolean busy = false;

    WashingMachine(String machineId) {
        this.machineId = machineId;
    }

    boolean isBusy() {
        return busy;
    }

    WashCycle startWash(Student1 student, WashType washType) {
        if (busy) {
            System.out.println("Machine " + machineId + " is currently busy.");
            return null;
        }
        busy = true;
        WashCycle cycle = new WashCycle(student, washType);
        System.out.println(washType.getName() + " wash started on " + machineId + " for " + student.name + " (" + washType.getDuration() + " min). Charge: ₹" + String.format("%.2f", washType.getCharge()));
        return cycle;
    }

    void completeCycle() {
        busy = false;
        System.out.println(machineId + " cycle completed. " + machineId + " is now free.");
    }
}

public class HostelLaundryQueue {
    public static void main(String[] args) {
        WashingMachine m1 = new WashingMachine("M1");
        WashingMachine m2 = new WashingMachine("M2");

        Student1 asha = new Student1("Asha");
        Student1 ravi = new Student1("Ravi");
        Student1 neha = new Student1("Neha");

        m1.startWash(asha, new QuickWash());
        m1.startWash(ravi, new HeavyWash());
        m2.startWash(ravi, new HeavyWash());
        m1.completeCycle();
        m1.startWash(neha, new NormalWash());
    }
}