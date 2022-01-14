import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Company company = new Company();
        ArrayList<Employee> staff = new ArrayList<>();

        for (int i = 1; i <= 180; i++) {
            staff.add(new Operator());
        }
        for (int i = 1; i <= 80; i++) {
            staff.add(new Manager());
        }
        for (int i = 1; i <= 10; i++) {
            staff.add(new TopManager());
        }

        company.hireAll(staff);
        System.out.println("Список из 15 самых высоких зарплат: " + company.getTopSalaryStaff(15) + "\n");
        System.out.println("Список из 30 самых низких зарплат: " + company.getLowestSalaryStaff(30) + "\n");

        for (int i = 0; i <= staff.size() / 2; i++) {
            company.fire(staff.get(i));
        }

        System.out.println("Список из 15 самых высоких зарплат: " + company.getTopSalaryStaff(15) + "\n");
        System.out.println("Список из 30 самых низких зарплат: " + company.getLowestSalaryStaff(30));
    }
}

