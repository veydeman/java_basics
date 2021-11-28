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
            //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО

            String regex = "(\\p{Alpha}+|\\p{Alpha}+-?\\p{Alpha}+|[а-яА-Я]+|[а-яА-Я]+-?[а-яА-Я]+)\\p{Space}" +
                    "(\\p{Alpha}+|[а-яА-Я]+)\\p{Space}(\\p{Alpha}+|[а-яА-Я]+)";
            String[] words = input.split("\\p{Space}");
            if (input.matches(regex)) {
                System.out.println("Фамилия: " + words[0]);
                System.out.println("Имя: " + words[1]);
                System.out.println("Отчество: " + words[2]);
            } else System.out.println("Введенная строка не является ФИО");
        }
    }
}