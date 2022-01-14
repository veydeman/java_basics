public abstract class Employee implements Comparable {

    protected double moneyGot = 0;
    protected Company company;
    protected double salary = 45_000;

    public Employee() {
//        salary = (int)(Math.random()*((250_000-50_000)+1))+250_000;
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
}
