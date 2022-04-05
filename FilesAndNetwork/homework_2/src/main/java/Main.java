import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("Введите путь к папке: ");
                Scanner scanner = new Scanner(System.in);
                String path = scanner.nextLine();
                System.out.println("Введите путь для копирования папки: ");
                String copyPath = scanner.nextLine();
                FileUtils.copyFolder(path, copyPath);
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
    }
}
