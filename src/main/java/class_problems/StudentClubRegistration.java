package week10.class_problems;

import java.util.HashSet;

public class StudentClubRegistration {

    static class Student {
        String rollNumber;
        String name;

        Student(String rollNumber, String name) {
            this.rollNumber = rollNumber;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Student)) return false;
            Student other = (Student) o;
            return rollNumber.equals(other.rollNumber);
        }

        @Override
        public int hashCode() {
            return rollNumber.hashCode();
        }
    }

    public static void main(String[] args) {
        String[] lines = {
            "ADD 21CS01 Asha",
            "ADD 21CS01 Asha",
            "ADD 21CS02 Ravi",
            "CONTAINS 21CS02 Ravi",
            "CONTAINS 21CS03 Priya"
        };

        HashSet<Student> members = new HashSet<>();
        boolean countPrinted = false;

        for (String line : lines) {
            String[] p = line.split(" ");
            if (p[0].equals("ADD")) {
                if (members.add(new Student(p[1], p[2]))) {
                    System.out.println("Added");
                } else {
                    System.out.println("duplicate rejected");
                }
            } else {
                if (!countPrinted) {
                    System.out.println("member count " + members.size());
                    countPrinted = true;
                }
                System.out.println("contains: " + members.contains(new Student(p[1], p[2])));
            }
        }

        if (!countPrinted) {
            System.out.println("member count " + members.size());
        }
    }
}