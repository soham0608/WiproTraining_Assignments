function processEmployees(employees) {
    console.log("Employee Details:");
    employees.forEach(function (emp) {
        console.log("ID: ".concat(emp.empId, ", Name: ").concat(emp.empName, ", Salary: ").concat(emp.salary));
    });
    return employees.length;
}
var employeeList = [
    { empId: 101, empName: "Soham Tanavade", salary: 50000 },
    { empId: 102, empName: "Rohit Patil", salary: 45000 },
    { empId: 103, empName: "Priyanka Patil", salary: 55000 }
];
var count = processEmployees(employeeList);
console.log("Total number of employees:", count);
