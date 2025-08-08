package AnynoumsFunct;

import java.util.*;

public class Ex11 {
    public static void main(String[] args) {
    	List<Employee> employees = new ArrayList<Employee>();

        employees.add(new Employee("E003", "Ravi", 30, 55000));
        employees.add(new Employee("E001", "Anita", 25, 60000));
        employees.add(new Employee("E002", "Vikram", 28, 58000));

        System.out.println("Original List:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }

        Collections.sort(employees, new Comparator<Employee>() {
            public int compare(Employee e1, Employee e2) {
                return e1.getEmpId().compareTo(e2.getEmpId());
            }
        });

        System.out.println("Sorted by empId:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }

        Collections.sort(employees, new Comparator<Employee>() {
            public int compare(Employee e1, Employee e2) {
                return e1.getEmpName().compareTo(e2.getEmpName());
            }
        });

        System.out.println("Sorted by empName:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
        
        Collections.sort(employees, new Comparator<Employee>() {
            public int compare(Employee e1, Employee e2) {
                return Integer.compare(e1.getEmpAge(), e2.getEmpAge());
            }
        });

        System.out.println("Sorted by empAge:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
}
