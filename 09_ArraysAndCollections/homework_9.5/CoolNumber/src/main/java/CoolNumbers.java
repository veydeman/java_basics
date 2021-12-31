import java.util.*;

public class CoolNumbers {

    public static List<String> generateCoolNumbers() {
        List<String> plates = new ArrayList<>();
        String[] alpha = new String[]{"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};
        String[] digits = new String[]{"111", "222", "333", "444", "555", "666", "777", "888", "999"};
        ArrayList<String> regions = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            regions.add("0".concat(Integer.toString(i)));
        }
        for (int i = 10; i <= 199; i++) {
            regions.add(Integer.toString(i));
        }
        for (String letter : alpha) {
            for (String num : digits) {
                for (String letter1 : alpha) {
                    for (String letter2 : alpha) {
                        for (String reg : regions) {
                            plates.add(letter.concat(num).concat(letter1).concat(letter2).concat(reg));
                        }
                    }
                }
            }
        }
        return plates;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        long start = System.nanoTime();
        if (list.contains(number)) {
            long estTime = System.nanoTime() - start;
            System.out.println("Поиск перебором: номер найден, поиск занял: " + estTime + " нс");
            return true;
        }
        long estTime = System.nanoTime() - start;
        System.out.println("Поиск перебором: номер не найден, поиск занял: " + estTime + " нс");
        return false;
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        long start = System.nanoTime();
        if (Collections.binarySearch(sortedList, number) >= 0) {
            long estTime = System.nanoTime() - start;
            System.out.println("Бинарный поиск: номер найден, поиск занял: " + estTime + " нс");
            return true;
        }
        long estTime = System.nanoTime() - start;
        System.out.println("Бинарный поиск: номер не найден, поиск занял: " + estTime + " нс");
        return false;
    }

    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        long start = System.nanoTime();
        if (hashSet.contains(number)) {
            long estTime = System.nanoTime() - start;
            System.out.println("Поиск в HashSet: номер найден, поиск занял: " + estTime + " нс");
            return true;
        }
        long estTime = System.nanoTime() - start;
        System.out.println("Поиск в HashSet: номер не найден, поиск занял: " + estTime + " нс");
        return false;
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        long start = System.nanoTime();
        if (treeSet.contains(number)) {
            long estTime = System.nanoTime() - start;
            System.out.println("Поиск в TreeSet: номер найден, поиск занял: " + estTime + " нс");
            return true;
        }
        long estTime = System.nanoTime() - start;
        System.out.println("Поиск в TreeSet: номер не найден, поиск занял: " + estTime + " нс");
        return false;
    }
}
