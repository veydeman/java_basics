import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int boxes = scanner.nextInt();
        int containers;
        int trucks;

        if (boxes == 0) {
            trucks = 0;
            containers = 0;
        } else {
            trucks = 1;
            containers = 1;
            System.out.print("Грузовик: " + trucks + System.lineSeparator());
            System.out.print("\tКонтейнер: " + containers + System.lineSeparator());
            for (int i = 1; i <= boxes; i++) {
                System.out.print("\t\tЯщик: " + i + System.lineSeparator());
                if ((i < boxes) && (i % 324 == 0)) {
                    trucks++;
                    System.out.print("Грузовик: " + trucks + System.lineSeparator());
                }
                if ((i < boxes) && (i % 27 == 0)) {
                    containers++;
                    System.out.print("\tКонтейнер: " + containers + System.lineSeparator());
                }
            }
        }

        System.out.print("Необходимо:" + System.lineSeparator());
        System.out.print("грузовиков - " + trucks + " шт." + System.lineSeparator());
        System.out.print("контейнеров - " + containers + " шт.");
    }
}

// TODO: вывести в консоль коробки разложенные по грузовикам и контейнерам
// пример вывода при вводе 2
// для отступа используйте табуляцию - \t

        /*
        Грузовик: 1
            Контейнер: 1
                Ящик: 1
                Ящик: 2
        Необходимо:
        грузовиков - 1 шт.
        контейнеров - 1 шт.
        */


