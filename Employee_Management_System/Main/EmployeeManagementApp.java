package Projects.Employee_Management_System.Main;

import Projects.Employee_Management_System.Service.EmployeeService;
import Projects.Employee_Management_System.Model.Employee;
 import Projects.Employee_Management_System.Model.Address;
 import Projects.Employee_Management_System.Model.ContractEmployee;
 import Projects.Employee_Management_System.Model.FullTimeEmployee;
 import Projects.Employee_Management_System.Model.PartTimeEmployee;
 import Projects.Employee_Management_System.Model.Department;

//package Projects.Employee_Management_System.Service.EmployeeService;



public class EmployeeManagementApp {

    public static void main(String[] args) {


        EmployeeService service = new EmployeeService();

        Address a1 =
                new Address("Chennai",
                        "Tamil Nadu",
                        "India");

        Address a2 =
                new Address("Coimbatore",
                        "Tamil Nadu",
                        "India");

        Address a3 =
                new Address("Salem",
                        "Tamil Nadu",
                        "India");

        FullTimeEmployee emp1 =
                new FullTimeEmployee(
                        101,
                        "Naveen",
                        Department.IT,
                        a1,
                        50000);

        PartTimeEmployee emp2 =
                new PartTimeEmployee(
                        102,
                        "Kumar",
                        Department.HR,
                        a2,
                        80,
                        300);

        ContractEmployee emp3 =
                new ContractEmployee(103, "Legend", Department.FINANCE, a3, 40000);

        service.addEmployee(emp1);
        service.addEmployee(emp2);
        service.addEmployee(emp3);

        service.displayEmployees();
    }
}