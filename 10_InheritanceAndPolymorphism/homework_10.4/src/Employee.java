public abstract class Employee implements Comparable {

    protected double moneyGot = 0;
    protected Company company;
    protected double salary = (int) (Math.random() * ((70000 - 50000) + 1)) + 70000;

    public Employee() {
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public double getMonthSalary() {
        return salary;
    }

    public double getMoneyGot() {
        return moneyGot;
    }

    @Override
    public int compareTo(Object o) {
        Employee employee = (Employee) o;
        return Double.compare(getMonthSalary(), employee.getMonthSalary());
    }

    @Override
    public String toString() {
        return "\n" + this.getClass().getName() + " {"
                + salary +
                "}";
    }
}