import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
//        while (true) {
        String input = scanner.nextLine();
//        if (input.equals("0")) {
//            break;
//        }

        //TODO:напишите ваш код тут, результат вывести в консоль.
        //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО
        char a = ' ';
        char b = 48;
        char c = 57;
        int space = input.indexOf(' ');
        int space1 = input.lastIndexOf(' ');
        int spaceCount = 0;
        boolean isDigit = false;

        if (input.isEmpty()) {
            System.out.println("Введенная строка не является ФИО");
        }
        if (!input.isEmpty()) {
            for (int i = 0; i < input.length(); i++) {
                if ((input.charAt(i) >= b) & (input.charAt(i) <= c)) {
                    isDigit = true;
                    break;
                }
                if (input.charAt(i) == a) {
                    spaceCount++;
                    if (spaceCount > 2)
                        break;
                }
            }
            if ((spaceCount != 2) | (isDigit)) {
                System.out.println("Введенная строка не является ФИО");
            } else if ((!isDigit) & (spaceCount == 2)) {
                System.out.println("Фамилия: " + input.substring(0, space) + "\n" + "Имя: "
                        + input.substring(space + 1, space1) + "\n" + "Отчество: " +
                        input.substring(space1 + 1));
            }
        }
    }
}


