package week6.assigment_problems;

class GymMember5 {
    final String membershipNumber;
    private int monthlyFee;
    private int feesPaid;
    private static int counter = 2000;

    public GymMember5(int monthlyFee) {
        counter++;
        this.membershipNumber = "GYM-" + counter;
        this.monthlyFee = monthlyFee;
    }

    void payFee(int amount) {
        feesPaid += amount;
    }

    void payFee(int amount, String mode) {
        payFee(amount);
    }

    int getFeesPaid() {
        return feesPaid;
    }

    static boolean isValidReferralCode(String code) {
        if (code.length() != 4) return false;
        if (code.charAt(0) != 'G') return false;
        if (!Character.isDigit(code.charAt(1))) return false;
        if (!Character.isDigit(code.charAt(2))) return false;
        if (!Character.isUpperCase(code.charAt(3))) return false;
        return true;
    }

    static int getMembersEnrolled() {
        return counter - 2000;
    }
}

class GroupClassMember5 extends GymMember5 {
    private String className;

    public GroupClassMember5(int monthlyFee, String className) {
        super(monthlyFee);
        this.className = className;
    }
}

public class GymMemberProblem5 {

    static String processWeeklyCheckIn(GymMember5[] members) {
        int processed = 0, nullSkipped = 0, group = 0, individual = 0;

        for (GymMember5 member : members) {
            if (member == null) {
                nullSkipped++;
                continue;
            }
            processed++;
            if (member instanceof GroupClassMember5) {
                group++;
            } else {
                individual++;
            }
        }

        return processed + " processed | " + nullSkipped + " null skipped | " + group + " group | " + individual + " individual";
    }

    public static void main(String[] args) {
        GymMember5 m1 = new GymMember5(1000);
        System.out.println(m1.membershipNumber);
        System.out.println(GymMember5.getMembersEnrolled());

        System.out.println(GymMember5.isValidReferralCode("G45B"));
        System.out.println(GymMember5.isValidReferralCode("G4B"));
        System.out.println(GymMember5.isValidReferralCode("X45B"));

        m1.payFee(500);
        m1.payFee(500, "UPI");
        System.out.println(m1.getFeesPaid());

        GymMember5[] members = {
            new GroupClassMember5(1500, "Zumba"),
            null,
            new GymMember5(1000)
        };
        System.out.println(processWeeklyCheckIn(members));
    }
}