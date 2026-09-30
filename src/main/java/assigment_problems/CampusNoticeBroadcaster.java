package week8.assigment_problems;

import java.util.*;

interface NotificationChannel {
    void send(String studentName, String message);
    String getChannelName();
}

class EmailChannel implements NotificationChannel {
    public void send(String studentName, String message) {
        System.out.println("[Email → " + studentName + "] " + message);
    }
    public String getChannelName() { return "Email"; }
}

class SmsChannel implements NotificationChannel {
    public void send(String studentName, String message) {
        System.out.println("[SMS → " + studentName + "] " + message);
    }
    public String getChannelName() { return "SMS"; }
}

class AppChannel implements NotificationChannel {
    public void send(String studentName, String message) {
        System.out.println("[App → " + studentName + "] " + message);
    }
    public String getChannelName() { return "App"; }
}

class Student5 {
    String name;
    String department;
    List<NotificationChannel> preferredChannels = new ArrayList<>();

    Student5(String name, String department, List<NotificationChannel> channels) {
        this.name = name;
        this.department = department;
        this.preferredChannels = channels;
    }
}

class Notice {
    String title;
    List<String> targetDepartments;

    Notice(String title, List<String> targetDepartments) {
        this.title = title;
        this.targetDepartments = targetDepartments;
    }
}

class NoticeBoard {
    List<Student5> students = new ArrayList<>();

    void addStudent(Student5 student) {
        students.add(student);
    }

    void postNotice(String title, List<String> targetDepartments) {
        if (title == null || title.trim().isEmpty()) {
            System.out.println("Cannot post notice: title is required.");
            return;
        }
        if (targetDepartments == null || targetDepartments.isEmpty()) {
            System.out.println("Cannot post notice: At least one target department is required.");
            return;
        }

        Notice notice = new Notice(title, targetDepartments);
        System.out.println("Notice '" + title + "' posted to " + String.join(", ", targetDepartments) + ".");

        for (Student5 student : students) {
            if (targetDepartments.contains(student.department)) {
                for (NotificationChannel channel : student.preferredChannels) {
                    channel.send(student.name, title);
                }
            }
        }
    }
}

public class CampusNoticeBroadcaster {
    public static void main(String[] args) {
        NoticeBoard board = new NoticeBoard();

        Student5 asha = new Student5("Asha", "CSE", Arrays.asList(new EmailChannel(), new AppChannel()));
        Student5 ravi = new Student5("Ravi", "ECE", Arrays.asList(new SmsChannel()));

        board.addStudent(asha);
        board.addStudent(ravi);

        board.postNotice("Lab Closed Tomorrow", Arrays.asList("CSE"));
        board.postNotice("Fee Deadline Extended", Arrays.asList("CSE", "ECE"));
        board.postNotice("Sports Day", new ArrayList<>());
    }
}