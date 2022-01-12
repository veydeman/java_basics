public class TopManager implements Employee {

    private double salary;

    public TopManager(double salary) {
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
