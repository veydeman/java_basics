import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("Введите путь к папке: ");
                Scanner scanner = new Scanner(System.in);
                String path = scanner.nextLine();
                System.out.println("Размер папки " + path + " составляет " +
                        FileUtils.getHumanReadableSize(FileUtils.calculateFolderSize(path)));
            } catch (NullPointerException exception) {
                System.out.println("Введен некорректный путь к папке");
            }
        }
    }
}
