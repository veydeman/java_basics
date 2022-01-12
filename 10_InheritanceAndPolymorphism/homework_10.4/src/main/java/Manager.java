public class Manager implements Employee {

    private double salary;

    public Manager(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public double getMonthSalary() {
        return Employee.super.getMonthSalary();
    }
}
