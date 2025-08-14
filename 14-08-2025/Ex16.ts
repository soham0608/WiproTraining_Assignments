interface Employee {
    empId: number;
    empName: string;
    salary: number;
}

function processEmployees(employees: Employee[]): number {
    console.log("Employee Details:");
    employees.forEach(emp => {
        console.log(`ID: ${emp.empId}, Name: ${emp.empName}, Salary: ${emp.salary}`);
    });
    return employees.length;
}

const employeeList: Employee[] = [
    { empId: 101, empName: "Soham Tanavade", salary: 50000 },
    { empId: 102, empName: "Rohit Patil", salary: 45000 },
    { empId: 103, empName: "Priyanka Patil", salary: 55000 }
];

const count = processEmployees(employeeList);
console.log("Total number of employees:", count);
