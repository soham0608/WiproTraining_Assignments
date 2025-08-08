package AnynoumsFunct;

public class Employee {
    private String empId;
    private String empName;
    private int empAge;
    private double empSalary;

    public Employee(String empId, String empName, int empAge, double empSalary) {
        this.empId = empId;
        this.empName = empName;
        this.empAge = empAge;
        this.empSalary = empSalary;
    }

    public String getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public int getEmpAge() {
        return empAge;
    }

    @Override
    public String toString() {
        return "Employee [ID=" + empId + ", Name=" + empName + ", Age=" + empAge + ", Salary=" + empSalary + "]";
    }
}