import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(CoolNumbers.generateCoolNumbers());
        Collections.sort(arrayList);
        CoolNumbers.binarySearchInList(arrayList, "А777МР77");

        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.addAll(arrayList);
        CoolNumbers.searchInTreeSet(treeSet, "Н761ЕР25");

        HashSet<String> hashSet = new HashSet<>();
        hashSet.addAll(arrayList);
        CoolNumbers.searchInHashSet(hashSet, "Х913МК13");

        CoolNumbers.bruteForceSearchInList(arrayList, "У132МН21");
    }
}
        /* Вывод: поиск в HashSet самый быстрый, а поиск перебором самый медленный. */