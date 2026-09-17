package week6.assigment_problems;

class GymMember1 {
    private String memberId;
    private int monthlyFee;
    private int sessionsAttended;

    public GymMember1(String memberId, int monthlyFee) {
        if (memberId == null || memberId.trim().isEmpty() || memberId.length() < 4) {
            throw new IllegalArgumentException("construction rejected");
        }
        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
        this.sessionsAttended = 0;
    }

    void attendSession() {
        sessionsAttended++;
    }

    int getSessionsAttended() {
        return sessionsAttended;
    }

    static String signUpBatch(String[] memberIds, int monthlyFee) {
        int signedUp = 0, rejected = 0;
        for (String id : memberIds) {
            try {
                new GymMember1(id, monthlyFee);
                signedUp++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }
        return "Signed Up: " + signedUp + " | Rejected: " + rejected;
    }
}

class PremiumMember1 extends GymMember1 {
    private String trainerName;

    public PremiumMember1(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }
}

public class GymMemberProblem1 {
    public static void main(String[] args) {
        try {
            new GymMember1("GM1", 1000);
        } catch (IllegalArgumentException e) {
            System.out.println("construction rejected");
        }

        PremiumMember1 p = new PremiumMember1("MEM01", 2000, "Coach Riya");
        p.attendSession();
        p.attendSession();
        System.out.println(p.getSessionsAttended());

        String[] ids = {"MEM1", "GM1", "MEM2", " ", "MEM3"};
        System.out.println(GymMember1.signUpBatch(ids, 1000));
    }
}