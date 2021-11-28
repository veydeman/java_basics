import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            //TODO:напишите ваш код тут, результат вывести в консоль.

            String regex = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)[\\d\\- ]{7,10}$";
            String regex1 = "[^\\d]";
            String regex3 = "8\\d{10}";

            if (input.matches(regex)) {
                input = input.replaceAll(regex1, "");
                if (input.length() == 11 && input.matches(regex3)) {
                    input = input.replaceFirst("8", "7");
                }
                if (input.length() == 10) {
                    input = "7" + input;
                }
                System.out.println(input);
            } else System.out.println("Неверный формат номера");
        }
    }
}

