package week8.assigment_problems;

abstract class Assignment2 {
    String title;
    int maxMarks;
    int dueDay;

    Assignment2(String title, int maxMarks, int dueDay) {
        this.title = title;
        this.maxMarks = maxMarks;
        this.dueDay = dueDay;
    }

    abstract double applyLatePenalty(double marks, int daysLate);
}

class CodingAssignment extends Assignment2 {
    CodingAssignment(String title, int maxMarks, int dueDay) {
        super(title, maxMarks, dueDay);
    }

    @Override
    double applyLatePenalty(double marks, int daysLate) {
        double penalty = marks * 0.10 * daysLate;
        return marks - penalty;
    }
}

class WrittenAssignment extends Assignment2 {
    WrittenAssignment(String title, int maxMarks, int dueDay) {
        super(title, maxMarks, dueDay);
    }

    @Override
    double applyLatePenalty(double marks, int daysLate) {
        double penalty = marks * 0.20 * daysLate;
        return marks - penalty;
    }
}

class Student2 {
    String name;

    Student2(String name) {
        this.name = name;
    }
}

class Submission {
    Student2 student;
    Assignment2 assignment;
    int submitDay;
    int daysLate;
    private String status = "Submitted";
    private double finalMarks;

    Submission(Student2 student, Assignment2 assignment, int submitDay) {
        this.student = student;
        this.assignment = assignment;
        this.submitDay = submitDay;
        this.daysLate = Math.max(0, submitDay - assignment.dueDay);
        String timing = daysLate == 0 ? "on time" : (daysLate + " days late");
        System.out.println(student.name + "'s submission for '" + assignment.title + "' received (" + timing + "). Status: Submitted");
    }

    void grade(double awardedMarks) {
        if (status.equals("Graded")) {
            System.out.println("Cannot resubmit: '" + assignment.title + "' has already been graded.");
            return;
        }
        if (daysLate > 0) {
            finalMarks = assignment.applyLatePenalty(awardedMarks, daysLate);
            int penaltyPercent = (assignment instanceof CodingAssignment) ? daysLate * 10 : daysLate * 20;
            System.out.println(student.name + " graded: " + (int) finalMarks + "/" + assignment.maxMarks + " after " + penaltyPercent + "% late penalty. Status: Graded");
        } else {
            finalMarks = awardedMarks;
            System.out.println(student.name + " graded: " + (int) finalMarks + "/" + assignment.maxMarks + ". Status: Graded");
        }
        status = "Graded";
    }

    void attemptResubmit() {
        if (status.equals("Graded")) {
            System.out.println("Cannot resubmit: '" + assignment.title + "' has already been graded.");
        }
    }
}

public class AssignmentSubmissionPortal {
    public static void main(String[] args) {
        CodingAssignment codingLab = new CodingAssignment("Linked List Lab", 50, 10);
        WrittenAssignment essay = new WrittenAssignment("Design Essay", 50, 12);

        Student2 asha = new Student2("Asha");
        Student2 ravi = new Student2("Ravi");

        Submission ashaSub = new Submission(asha, codingLab, 10);
        Submission raviSub = new Submission(ravi, essay, 14);

        ashaSub.grade(45);
        raviSub.grade(40);

        ashaSub.attemptResubmit();
    }
}