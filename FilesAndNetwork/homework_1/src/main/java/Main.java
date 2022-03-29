import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Введите путь до папки: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        System.out.println("Размер папки " + path + " составляет " +
                FileUtils.getHumanReadableSize(FileUtils.calculateFolderSize(path)));
    }
}
