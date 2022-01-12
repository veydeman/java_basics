public class Operator implements Employee {

    private double salary;

    public Operator(double salary) {
        this.salary = (Math.random() * ((200_000 - 40_000) + 1)) + 40_000;
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
