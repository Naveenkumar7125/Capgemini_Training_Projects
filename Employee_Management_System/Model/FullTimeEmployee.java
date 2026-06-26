package Projects.Employee_Management_System.Model;


public class FullTimeEmployee extends Employee {

    private double monthlySalary;

    public FullTimeEmployee(int empId,
                            String name,
                            Department dept,
                            Address add,
                            double monthlySalary) {

        super(empId, name, dept, add);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calcSalary() {
        return monthlySalary;
    }
}
