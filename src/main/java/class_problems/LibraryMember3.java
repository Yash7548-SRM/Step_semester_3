package week6.class_problems;

class LibraryMember3 {
    private String memberId;
    private int borrowLimit;
    private int[] fineHistory = new int[10];
    private int fineCount = 0;

    public LibraryMember3(String memberId, int borrowLimit) {
        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
    }

    protected void chargeFine(int amount) {
        fineHistory[fineCount] = amount;
        fineCount++;
    }

    int[] getFineHistory() {
        int[] copy = new int[fineCount];
        for (int i = 0; i < fineCount; i++) copy[i] = fineHistory[i];
        return copy;
    }

    int getTotalFine() {
        int total = 0;
        for (int i = 0; i < fineCount; i++) total += fineHistory[i];
        return total;
    }
}

class StudentMember3 extends LibraryMember3 {
    private String course;

    public StudentMember3(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }

    @Override
    protected void chargeFine(int amount) {
        super.chargeFine(amount / 2);
    }
}

public class LibraryMemberProblem3 {
    public static void main(String[] args) {
        StudentMember3 s = new StudentMember3("STU5", 3, "CSE");
        s.chargeFine(100);
        System.out.println(s.getTotalFine());

        int[] history = s.getFineHistory();
        history[0] = 999;
        System.out.println(java.util.Arrays.toString(s.getFineHistory()));
    }
}