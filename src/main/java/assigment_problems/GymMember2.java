package week6.assigment_problems;

class GymMember2 {
    private String memberId;
    private int monthlyFee;
    private int sessionsAttended;

    public GymMember2(String memberId, int monthlyFee) {
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

    String displayInfo() {
        return "Standard Member | Sessions: " + sessionsAttended;
    }
}

class PremiumMember2 extends GymMember2 {
    private String trainerName;

    public PremiumMember2(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    @Override
    String displayInfo() {
        return "Premium Member | Trainer: " + trainerName + " | Sessions: " + getSessionsAttended();
    }
}

class EliteMember2 extends PremiumMember2 {
    private String lockerNumber;

    public EliteMember2(String memberId, int monthlyFee, String trainerName, String lockerNumber) {
        super(memberId, monthlyFee, trainerName);
        this.lockerNumber = lockerNumber;
    }

    @Override
    String displayInfo() {
        return "Elite Member | Locker: " + lockerNumber + " | Sessions: " + getSessionsAttended();
    }
}

class GroupClassMember2 extends GymMember2 {
    private String className;

    public GroupClassMember2(String memberId, int monthlyFee, String className) {
        super(memberId, monthlyFee);
        this.className = className;
    }

    @Override
    String displayInfo() {
        return "Group Class Member | Class: " + className + " | Sessions: " + getSessionsAttended();
    }
}

public class GymMemberProblem2 {

    static String classifyGeneration(GymMember2 member) {
        if (member instanceof EliteMember2) {
            return "Multilevel descendant (3 generations deep)";
        }
        if (member instanceof GroupClassMember2) {
            return "Hierarchical sibling (independent branch)";
        }
        return "Unclassified";
    }

    static int getTotalSessionsAttended(GymMember2[] members) {
        int total = 0;
        for (GymMember2 member : members) {
            total += member.getSessionsAttended();
        }
        return total;
    }

    public static void main(String[] args) {
        GymMember2 standard = new GymMember2("MEM1", 1000);
        PremiumMember2 premium = new PremiumMember2("MEM2", 2000, "Coach Riya");
        EliteMember2 elite = new EliteMember2("MEM3", 3000, "Coach Arjun", "L12");
        GroupClassMember2 group = new GroupClassMember2("MEM4", 1500, "Zumba");

        System.out.println(standard.displayInfo());
        System.out.println(premium.displayInfo());
        System.out.println(elite.displayInfo());
        System.out.println(group.displayInfo());

        System.out.println(classifyGeneration(elite));
        System.out.println(classifyGeneration(group));

        premium.attendSession();
        premium.attendSession();
        premium.attendSession();
        elite.attendSession();
        elite.attendSession();
        group.attendSession();
        group.attendSession();
        group.attendSession();
        group.attendSession();

        System.out.println(getTotalSessionsAttended(new GymMember2[]{premium, elite, group}));
    }
}