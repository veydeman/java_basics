import java.util.Scanner;

public class Main {
    private static EmailList emailList = new EmailList();
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";
    public static final String EMAIL_PATTERN = "(ADD|Add|add)\\p{Space}(\\p{Alpha}+@\\p{Alpha}+)\\.(\\p{Alpha}+)";
    public static final String LIST_REGEX = "LIST|list|List";

    /* TODO:
        Пример вывода списка Email, после ввода команды LIST в консоль:
        test@test.com
        hello@mail.ru
        - каждый адрес с новой строки
        - список должен быть отсортирован по алфавиту
        - email в разных регистрах считается одинаковыми
           hello@skillbox.ru == HeLLO@SKILLbox.RU
        - вывод на печать должен быть в нижнем регистре
           hello@skillbox.ru
        Пример вывода сообщения об ошибке при неверном формате Email:
        "Неверный формат email"
    */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            //TODO: write code here
            else if (input.matches(LIST_REGEX)) {
                emailList.getSortedEmails();
            } else if (input.matches(EMAIL_PATTERN)) {
                emailList.add(input.substring(4));
            } else System.out.println(WRONG_EMAIL_ANSWER);
        }
    }
}
