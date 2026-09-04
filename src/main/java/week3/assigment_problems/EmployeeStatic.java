package week3.assigment_problems;

class EmployeeStatic {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    EmployeeStatic(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class EmployeeStaticDemo {
    public static void main(String[] args) {
        EmployeeStatic e1 = new EmployeeStatic("A", 10000);
        EmployeeStatic e2 = new EmployeeStatic("B", 20000);
        EmployeeStatic e3 = new EmployeeStatic("C", 30000);

        EmployeeStatic.printCompanyInfo();
    }
}