package week6.class_problems;

class LibraryMember4 {
    private String memberId;
    private int borrowLimit;
    private int booksBorrowed;

    public LibraryMember4(String memberId, int borrowLimit) {
        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
    }

    int getBooksBorrowed() {
        return booksBorrowed;
    }

    String displayInfo() {
        return "General | Books: " + booksBorrowed;
    }
}

class StudentMember4 extends LibraryMember4 {
    private String course;

    public StudentMember4(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }

    String getCourse() {
        return course;
    }

    @Override
    String displayInfo() {
        return "Student | Course: " + course + " | Books: " + getBooksBorrowed();
    }
}

public class LibraryMemberProblem4 {

    static String batchPrint(LibraryMember4[] members) {
        StringBuilder report = new StringBuilder();
        for (LibraryMember4 member : members) {
            report.append(member.displayInfo());
            if (member instanceof StudentMember4) {
                StudentMember4 student = (StudentMember4) member;
                report.append(" [Course via downcast: ").append(student.getCourse()).append("]");
            }
            report.append(" | ");
        }
        return report.toString();
    }

    public static void main(String[] args) {
        LibraryMember4[] members = {
            new LibraryMember4("LB5", 3),
            new StudentMember4("STU6", 3, "ECE")
        };
        System.out.println(batchPrint(members));

        LibraryMember4 plain = new LibraryMember4("LB6", 3);
        StudentMember4 bad = (StudentMember4) plain;
    }
}