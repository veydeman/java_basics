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

//        for (String a : plates
//        ) {
//            System.out.print(a);
//        }
        System.out.println(plates.size());
        return plates;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        return false;
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {

        return false;
    }


    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {

        return false;
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {

        return false;
    }

}
