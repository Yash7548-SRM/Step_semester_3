package week6.assigment_problems;

class GymMember4 {
    private String memberId;
    private int monthlyFee;
    private int sessionsAttended;

    public GymMember4(String memberId, int monthlyFee) {
        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
    }

    int getSessionsAttended() {
        return sessionsAttended;
    }

    String displayInfo() {
        return "Standard | Sessions: " + sessionsAttended;
    }
}

class PremiumMember4 extends GymMember4 {
    private String trainerName;

    public PremiumMember4(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    String getTrainerName() {
        return trainerName;
    }

    @Override
    String displayInfo() {
        return "Premium | Trainer: " + trainerName + " | Sessions: " + getSessionsAttended();
    }
}

public class GymMemberProblem4 {

    static String batchPrint(GymMember4[] members) {
        StringBuilder announcement = new StringBuilder();
        for (GymMember4 member : members) {
            announcement.append(member.displayInfo());
            if (member instanceof PremiumMember4) {
                PremiumMember4 premium = (PremiumMember4) member;
                announcement.append(" [Trainer via downcast: ").append(premium.getTrainerName()).append("]");
            }
            announcement.append(" | ");
        }
        return announcement.toString();
    }

    public static void main(String[] args) {
        GymMember4[] members = {
            new GymMember4("MEM6", 1000),
            new PremiumMember4("MEM7", 2000, "Coach Riya")
        };
        System.out.println(batchPrint(members));

        GymMember4 plain = new GymMember4("MEM8", 1000);
        PremiumMember4 bad = (PremiumMember4) plain;
    }
}