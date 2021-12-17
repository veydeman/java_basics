import java.util.Scanner;

public class Main {

    public static final String LIST_PATTERN = "LIST|list|List";
//    public static final String PHONE_PATTERN = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)[\\d\\- ]{7,10}$";
    public static final String PHONE_PATTERN = "\\d{11}";
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();
        while (true) {
            System.out.println("Введите имя, телефон или команду");
            String a = scanner.nextLine();
            if (a.matches(PHONE_PATTERN + "\\p{Space}" + "\\p{Alpha}+")) {
                phoneBook.addContact(a.substring(0,10),a.substring(12));
            }
            phoneBook.getAllContacts();

            if (a.matches(LIST_PATTERN)) {
                phoneBook.getAllContacts();
            }


        }
    }
}
