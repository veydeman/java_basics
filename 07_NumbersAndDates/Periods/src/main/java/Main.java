import java.time.LocalDate;
import java.time.Period;

public class Main {

    public static void main(String[] args) {
        LocalDate birthday = LocalDate.of(1995, 5, 23);
        getPeriodFromBirthday(birthday);
    }

    private static String getPeriodFromBirthday(LocalDate birthday) {

        LocalDate now = LocalDate.now();
        int a = Period.between(birthday, now).getYears();
        int b = Period.between(birthday, now).getMonths();
        int c = Period.between(birthday, now).getDays();
        System.out.println(a + " years, " + b + " months, " + c + " days ");
        return a + " years, " + b + " months, " + c + " days ";
    }
}


