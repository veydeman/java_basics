import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String str = "Оля заработала 32000 рублей, Петя заработал 24000 руб.";
        String str1 = "Никто ничего не заработал.";
        System.out.println(calculateSalarySum(str1));
    }

    public static int calculateSalarySum(String text) {
        //TODO: реализуйте метод
        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        int totalSalary = 0;
        while (matcher.find()) {
            String a = matcher.group();
            totalSalary += Integer.parseInt(a);
        }
        if (totalSalary == 0) {
            System.out.println("Никто ничего не заработал");
        }
        return totalSalary;
    }
}
