import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        Operator a = new Operator();
//        System.out.println(a.getSalary());
//        Operator b = new Operator();
//        System.out.println(b.getSalary());
//        Manager manager = new Manager();
//        System.out.println(manager.getSalary());
//        TopManager topManager = new TopManager();
//        System.out.println(topManager.getSalary());
//
        Company company = new Company();
        Manager manager = new Manager();
        Operator operator = new Operator();
        TopManager topManager = new TopManager();
        Manager manager2 = new Manager();
        ArrayList<Employee> staff = new ArrayList<>();
        staff.add(manager);
        staff.add(operator);
        staff.add(topManager);
        staff.add(manager2);
        System.out.println(company.hireAll(staff));
//        System.out.println(company.getIncome());
//        System.out.println(operator.getMonthSalary());
//        System.out.println(company.getTopSalaryStaff(3));
//        System.out.println(company.getLowestSalaryStaff(3));

    }
}

