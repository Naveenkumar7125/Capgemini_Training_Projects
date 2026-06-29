# Employee Management System

## What this module is

A small Java-based Employee Management mini-application used for training and demonstration. It models employees, departments and addresses, provides concrete employee types (full-time, part-time, contract), and includes a simple service class to add and display employees. The provided Main classes show how to create model instances and exercise the service.

## Quick start

Compile and run from the repository root (requires JDK):

```bash
# compile all Java files
javac -d out $(find Employee_Management_System -name "*.java")

# run the example application
java -cp out Projects.Employee_Management_System.Main.EmployeeManagementApp
# or run the minimal starter
java -cp out Projects.Employee_Management_System.Main.EmployeeMgtApp
```

## Repository layout (relevant files)

Employee_Management_System/
- Main/
  - EmployeeManagementApp.java       — example application that constructs employees and uses the service
  - EmployeeMgtApp.java             — small starter/main scaffold
- Model/
  - Address.java                    — Address value object
  - Employee.java                   — base employee class (common fields + constructor)
  - FullTimeEmployee.java           — full-time employee subtype
  - PartTimeEmployee.java           — part-time employee subtype
  - ContractEmployee.java           — contract employee subtype (overrides salary calculation)
  - Department.java                 — department enumeration / constants
- Service/
  - EmployeeService.java            — in-memory service for managing Employee instances

## High-level design and flow

- Models define the domain: Employee is the common base and specific employee types extend it to represent different pay models. Address and Department are supporting types.
- EmployeeService acts as the application/business layer for storing and operating on Employee objects (the main code calls service.addEmployee(...) and service.displayEmployees()).
- Main classes create model instances (Address, employee subtypes) and call the service to register and print them — this demonstrates usage and serves as a manual test harness.

## Detailed class and file descriptions

### Model/Address.java
- Fields: city, state, country.
- Behavior: constructor to set the fields and a toString() override that returns a single-line formatted address (city, state, country).
- Purpose: simple value object used by Employee instances to record location details.

### Model/Employee.java
- Role: base class for all employee types.
- Observed constructor signature (used by subclasses): super(int empId, String name, Department dept, Address add)
  - From the code, Employee stores at least: employee id, name, department, and address.
- Likely responsibilities: common getters, shared functionality (for example: full name or toString), and a salary-calculation method that subclasses override.

### Model/FullTimeEmployee.java
- Purpose: represent salaried / full-time staff.
- Observed usage: constructed with (id, name, Department, Address, salary).
- Likely behavior: stores an annual/monthly salary value and implements calcSalary() to return that salary.

### Model/PartTimeEmployee.java
- Purpose: represent part-time staff.
- Observed usage: constructed with (id, name, Department, Address, hours, rate) — main app provides values like 80 and 300, which indicate hours and an hourly rate (or similar).
- Likely behavior: calcSalary() computes pay as hours * rate (or similar) for the pay period.

### Model/ContractEmployee.java
- Extends Employee.
- Field: contractAmount (double).
- Constructor delegates to Employee and stores contractAmount.
- Overrides calcSalary(): returns the contractAmount.
- Purpose: models a contractor paid a fixed contract amount rather than hourly/salary.

### Model/Department.java
- Represents departments used throughout the models.
- Observed values used in main: Department.IT, Department.HR, Department.FINANCE.
- Purpose: simple enum or class with constants representing organizational departments.

### Service/EmployeeService.java
- Observed usage in main:
  - new EmployeeService()
  - service.addEmployee(empX)
  - service.displayEmployees()
- Purpose (from code and usage): an in-memory manager that stores Employee instances (likely in a List) and provides operations to add employees and display/print them.
- Likely additional responsibilities you can add: search by id, compute total payroll, remove/modify employees, persist or export employees.

## Main/EmployeeManagementApp.java (example flow)
- Instantiates EmployeeService.
- Creates three Address objects.
- Creates three employees:
  - FullTimeEmployee(101, "Naveen", Department.IT, a1, 50000)
  - PartTimeEmployee(102, "Kumar", Department.HR, a2, 80, 300)
  - ContractEmployee(103, "Legend", Department.FINANCE, a3, 40000)
- Adds the employees to the service via addEmployee(...)
- Calls service.displayEmployees() to print the stored employees.
- Purpose: runnable demonstration of model + service interaction and basic program output.

## Main/EmployeeMgtApp.java
- Minimal scaffold showing creation of EmployeeService and an Address instance; useful as a starting point for adding more interactive logic or tests.

## How the pieces fit together

- The model classes (Employee + subtypes) encapsulate employee data and pay-calculation behavior.
- Department and Address are supporting types referenced by Employee objects.
- EmployeeService acts as a simple application layer that holds a collection of Employee objects and exposes operations to the rest of the program.
- The Main classes construct model instances and use EmployeeService to exercise functionality, making the app runnable without additional setup.

## Examples of extending this project

- Persist employees: replace the in-memory list in EmployeeService with file- or database-backed storage (JDBC, JPA, SQLite).
- Add CRUD operations: implement findById, updateEmployee, removeEmployee.
- Add I/O: read employees from a CSV/JSON file and export the current employee list.
- Add input handling: interactive console menu (add, list, remove, compute payroll), or a simple GUI or web API.
- Implement unit tests for calcSalary() on each subtype and for EmployeeService behaviors.

## Notes & assumptions (based on inspected code)

- The README above is written from the actual files present in Employee_Management_System. The main observed methods used by the app are addEmployee(...) and displayEmployees() on EmployeeService and calcSalary overrides on ContractEmployee.
- Some implementation details (exact names of fields or additional service methods) were inferred from constructor signatures and usages in Main; inspect the individual Java files for any additional methods or fields not described here.
