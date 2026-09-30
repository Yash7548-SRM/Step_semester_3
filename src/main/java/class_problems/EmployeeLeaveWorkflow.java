package week8.class_problems;

abstract class Employee2 {
    String name;

    Employee2(String name) {
        this.name = name;
    }
}

class FullTimeEmployee extends Employee2 {
    FullTimeEmployee(String name) {
        super(name);
    }
}

class PartTimeEmployee extends Employee2 {
    PartTimeEmployee(String name) {
        super(name);
    }
}

class LeaveRequest {
    Employee2 employee;
    String startDate;
    String endDate;
    String status = "Pending";

    LeaveRequest(Employee2 employee, String startDate, String endDate) {
        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
        System.out.println("Leave request submitted for " + employee.name + " (" + startDate + "-" + endDate + "). Status: Pending");
    }

    void approve() {
        if (!status.equals("Pending")) {
            System.out.println("Cannot change leave request status from " + status + " to Approved");
            return;
        }
        status = "Approved";
        System.out.println(employee.name + "'s leave request (" + startDate + "-" + endDate + ") approved. Status: Approved");
    }

    void reject() {
        if (!status.equals("Pending")) {
            System.out.println("Cannot change leave request status from " + status + " to Rejected");
            return;
        }
        status = "Rejected";
        System.out.println(employee.name + "'s leave request (" + startDate + "-" + endDate + ") rejected. Status: Rejected");
    }

    void setPending() {
        System.out.println("Cannot change leave request status from " + status + " to Pending");
    }
}

public class EmployeeLeaveWorkflow {
    public static void main(String[] args) {
        FullTimeEmployee john = new FullTimeEmployee("John");
        LeaveRequest johnRequest = new LeaveRequest(john, "Jan 1", "Jan 5");
        johnRequest.approve();

        PartTimeEmployee jane = new PartTimeEmployee("Jane");
        LeaveRequest janeRequest = new LeaveRequest(jane, "Feb 10", "Feb 11");
        janeRequest.reject();

        johnRequest.setPending();
    }
}