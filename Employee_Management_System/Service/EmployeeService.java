package Projects.Employee_Management_System.Service;

import Projects.Employee_Management_System.Model.Employee;
import Projects.Employee_Management_System.Model.FullTimeEmployee;
import Projects.Employee_Management_System.Model.PartTimeEmployee;
import Projects.Employee_Management_System.Model.ContractEmployee;


import java.util.*;

public class EmployeeService {

    private List<Employee> employees = new ArrayList<>();
    public void addEmployee(Employee employee)
    {
        employees.add(employee);
    }
    public void displayEmployees()
    {
        for(Employee emp : employees)
        {
            emp.displayBasicInfo();
            System.out.println(emp.calcSalary());
        }
    }
    public void updateName(int empId, String name)
    {
        for(Employee emp : employees)
        {
            if(emp.empId == empId)
            {
                emp.name = name;
            }
        }
    }
    public void totalSalaryExpense()
    {
        double total = 0;

        for(Employee emp : employees)
        {
            total += emp.calcSalary();
        }
        System.out.println("Total Salary Expense " + total);
    }
}
