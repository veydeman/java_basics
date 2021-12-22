import java.util.Scanner;

public class Main {

    public static final String LIST_PATTERN = "LIST|list|List";
    public static final String PHONE_PATTERN = "\\d{11}";
    public static final String NAME_PATTERN = "\\p{IsAlphabetic}+";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PhoneBook book = new PhoneBook();
        while (true) {
            System.out.println("Введите номер, имя или команду");
            String a = scanner.nextLine();
            String b;
            if (a.matches(PHONE_PATTERN + "\\p{Space}" + "\\p{IsAlphabetic}+")) {
                book.addContact(a.substring(0, 11), a.substring(12));
            } else if (a.matches(LIST_PATTERN)) {
                book.getAllContacts();
            } else if (a.matches(PHONE_PATTERN)) {
                if (book.phoneList.containsValue(a)) {
                    book.getContactByPhone(a);
                } else {
                    System.out.println("Такого номера нет в телефонной книге.\nВведите имя абонента для номера \""
                            + a + "\":");
                    b = scanner.nextLine();
                    if (b.matches(NAME_PATTERN)) {
                        book.addContact(a, b);
                    } else System.out.println("Неверный формат ввода");
                }
            } else if (a.matches(NAME_PATTERN)) {
                if (book.phoneList.containsKey(a)) {
                    book.getContactByName(a);
                } else {
                    System.out.println("Такого имени в телефонной книге нет.\nВведите номер телефона для абонента \""
                            + a + "\":");
                    b = scanner.nextLine();
                    if (b.matches(PHONE_PATTERN)) {
                        book.addContact(b, a);
                    } else System.out.println("Неверный формат ввода");
                }
            } else System.out.println("Неверный формат ввода");
        }
    }
}

