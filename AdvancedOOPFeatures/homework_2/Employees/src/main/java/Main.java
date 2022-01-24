import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Main {

    private static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        Employee employeeMaxSalary = findEmployeeWithHighestSalary(staff, 2017);
        System.out.println(employeeMaxSalary);
    }

    public static Employee findEmployeeWithHighestSalary(List<Employee> staff, int year) {
        String dateFormat = "dd.MM.yyyy";
        SimpleDateFormat a = new SimpleDateFormat(dateFormat);
        ArrayList<Employee> result = staff.stream().filter(employee -> a.format(employee.getWorkStart())
                .substring(6, 10).equals(Integer.toString(year))).max(Comparator.comparing(Employee::getSalary))
                .stream().collect(Collectors.toCollection(ArrayList::new));
        return result.get(result.size() - 1);
    }
}