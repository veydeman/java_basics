import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        int day = 14;
        int month = 11;
        int year = 2015;

        System.out.println(collectBirthdays(year, month, day));
    }

    public static String collectBirthdays(int year, int month, int day) {

        String a = "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy - E", Locale.US);
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(year, month, day);
        formatter.format(birthday);
        int x = Period.between(birthday, today).getYears();

        if (birthday.isEqual(today)) {
            a = 0 + a + " - " + formatter.format(birthday) + System.lineSeparator();
            return a;
        } else if (birthday.isAfter(today))
            return "";
        for (int i = 0; i <= x; i++) {
            if (birthday.isBefore(today)) {
                a += i + " - " + formatter.format((birthday.plusYears(i))) + System.lineSeparator();
                if (birthday.plusYears(i + 1).isAfter(today)) {
                    break;
                }
            }
        }
        return a + "";
    }
}

//TODO реализуйте метод для построения строки в следующем виде
//0 - 31.12.1990 - Mon
//1 - 31.12.1991 - Tue





