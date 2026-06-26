package Projects.Employee_Management_System.Model;

public class PartTimeEmployee extends Employee {

    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(int empId,
                            String name,
                            Department dept,
                            Address add,
                            int hoursWorked,
                            double hourlyRate) {

        super(empId, name, dept, add);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calcSalary() {
        return hoursWorked * hourlyRate;
    }
}
