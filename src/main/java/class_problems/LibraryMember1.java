package week6.class_problems;

class LibraryMember1 {
    private String memberId;
    private int borrowLimit;
    private int booksBorrowed;

    public LibraryMember1(String memberId, int borrowLimit) {
        if (memberId == null || memberId.trim().isEmpty() || memberId.length() < 4) {
            throw new IllegalArgumentException("construction rejected");
        }
        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
        this.booksBorrowed = 0;
    }

    void borrowBook() {
        booksBorrowed++;
    }

    int getBooksBorrowed() {
        return booksBorrowed;
    }

    static String enrollBatch(String[] memberIds, int borrowLimit) {
        int enrolled = 0, rejected = 0;
        for (String id : memberIds) {
            try {
                new LibraryMember1(id, borrowLimit);
                enrolled++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }
        return "Enrolled: " + enrolled + " | Rejected: " + rejected;
    }
}

class StudentMember1 extends LibraryMember1 {
    private String course;

    public StudentMember1(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }
}

public class LibraryMemberProblem1 {
    public static void main(String[] args) {
        try {
            new LibraryMember1("LB1", 3);
        } catch (IllegalArgumentException e) {
            System.out.println("construction rejected");
        }

        StudentMember1 s = new StudentMember1("STU10", 3, "CSE");
        s.borrowBook();
        s.borrowBook();
        System.out.println(s.getBooksBorrowed());

        String[] ids = {"STU1", "LB1", "STU2", " ", "STU3"};
        System.out.println(LibraryMember1.enrollBatch(ids, 3));
    }
}