import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите путь к папке: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        System.out.println("Введите путь для сохранения папки: ");
        Scanner scanner1 = new Scanner(System.in);
        String copyPath = scanner.nextLine();
    }
}
