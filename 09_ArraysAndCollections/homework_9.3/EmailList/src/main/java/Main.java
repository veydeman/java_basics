import java.util.Scanner;

public class Main {
    private static EmailList emailList = new EmailList();
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";
    public static final String EMAIL_PATTERN = "(ADD|Add|add)\\p{Space}(\\p{Alpha}+@\\p{Alpha}+)\\.(\\p{Alpha}+)";
    public static final String LIST_REGEX = "LIST|list|List";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            } else if (input.matches(LIST_REGEX)) {
                emailList.getSortedEmails();
            } else if (input.matches(EMAIL_PATTERN)) {
                emailList.add(input.substring(4));
            } else System.out.println(WRONG_EMAIL_ANSWER);
        }
    }
}
