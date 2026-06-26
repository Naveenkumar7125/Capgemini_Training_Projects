package Projects.Employee_Management_System.Model;


public abstract class Employee{
    public  int empId;
    public String name;
    protected Department dept;
    protected Address add;


    public Employee(int empId,String name,Department dept,Address add) {
        this.empId=empId;
        this.name=name;
        this.dept=dept;
        this.add=add;
    }
    public abstract double calcSalary();
    public void displayBasicInfo() {
        System.out.println("Emp Id : "+empId);
        System.out.println("Emp Name : "+name);
        System.out.println("Emp Dept : "+dept);
        System.out.println("Emp Address : "+add);
    }
}
