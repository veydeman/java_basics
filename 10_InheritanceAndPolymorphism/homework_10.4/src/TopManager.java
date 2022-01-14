public class TopManager extends Employee {

    public TopManager() {
        super();
        double baseSalary = super.salary;
        salary = (baseSalary * 150) / 100;
    }
}
