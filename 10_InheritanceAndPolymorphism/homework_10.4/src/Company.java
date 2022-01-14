import java.util.ArrayList;
import java.util.Collections;

public class Company {
    ArrayList<Employee> employees = new ArrayList<>();

    public ArrayList hire(Employee employee) {
        employees.add(employee);
        employee.setCompany(this);
        return employees;

    }

    public ArrayList hireAll(ArrayList<Employee> staff) {
        for (Employee i : staff) {
            hire(i);
        }
        return employees;
    }

    public ArrayList fire(Employee employee) {
        employees.remove(employee);
        return employees;
    }

    public double getIncome() {
        double income = 0;
        for(Employee a : employees){
            income += a.getMoneyGot();
        }
        return income;
    }

    public ArrayList<Employee> getTopSalaryStaff(int count) {
        Collections.reverse(employees);
        ArrayList<Employee> reversedList = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            reversedList.add(employees.get(i));
        }
        return reversedList;
    }

    public ArrayList<Employee> getLowestSalaryStaff(int count) {
        Collections.sort(employees);
//        List sortedList = employees.sublist();
        ArrayList<Employee> sortedList = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            sortedList.add(employees.get(i));
        }
        return sortedList;
    }
}
