package week8.assigment_problems;

abstract class MembershipPlan {
    static final double BASE_RATE = 1000;
    abstract int getMonths();
    abstract double calculateFee();
    abstract String getName();
}

class MonthlyPlan extends MembershipPlan {
    int getMonths() { return 1; }
    double calculateFee() { return BASE_RATE * 1; }
    String getName() { return "Monthly"; }
}

class QuarterlyPlan extends MembershipPlan {
    int getMonths() { return 3; }
    double calculateFee() { return BASE_RATE * 3 * 0.90; }
    String getName() { return "Quarterly"; }
}

class AnnualPlan extends MembershipPlan {
    int getMonths() { return 12; }
    double calculateFee() { return BASE_RATE * 12 * 0.75; }
    String getName() { return "Annual"; }
}

class Member4 {
    String name;

    Member4(String name) {
        this.name = name;
    }
}

class Membership {
    Member4 member;
    MembershipPlan plan;
    private String status = "Active";

    Membership(Member4 member, MembershipPlan plan) {
        this.member = member;
        this.plan = plan;
        System.out.println(plan.getName() + " membership created for " + member.name + ". Fee: ₹" + String.format("%.2f", plan.calculateFee()) + ". Status: Active");
    }

    void checkIn() {
        if (!status.equals("Active")) {
            System.out.println("Check-in denied: " + member.name + "'s membership is " + status + ".");
            return;
        }
        System.out.println(member.name + " checked in successfully.");
    }

    void freeze() {
        if (status.equals("Expired")) {
            System.out.println("Cannot freeze an Expired membership.");
            return;
        }
        status = "Frozen";
        System.out.println(member.name + "'s membership frozen. Status: Frozen");
    }

    void unfreeze() {
        if (status.equals("Expired")) {
            System.out.println("Cannot unfreeze an Expired membership.");
            return;
        }
        status = "Active";
        System.out.println(member.name + "'s membership unfrozen. Status: Active");
    }

    void expire() {
        status = "Expired";
        System.out.println(member.name + "'s membership expired. Status: Expired");
    }
}

public class FitZoneMembershipDesk {
    public static void main(String[] args) {
        Member4 asha = new Member4("Asha");
        Member4 ravi = new Member4("Ravi");

        Membership ashaMembership = new Membership(asha, new QuarterlyPlan());
        Membership raviMembership = new Membership(ravi, new MonthlyPlan());

        ashaMembership.checkIn();
        ashaMembership.freeze();
        ashaMembership.checkIn();

        raviMembership.expire();
        raviMembership.freeze();
    }
}