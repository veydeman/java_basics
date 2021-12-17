import java.util.ArrayList;
import java.util.TreeSet;

public class EmailList {
    public static final String EMAIL_PATTERN = "(\\p{Alpha}+@\\p{Alpha}+)\\.(\\p{Alpha}+)";
    TreeSet<String> treeSet = new TreeSet<>();

    public void add(String email) {
        if (email.matches(EMAIL_PATTERN)) {
            treeSet.add(email.toLowerCase());
        }
    }

    public ArrayList<String> getSortedEmails() {
        ArrayList<String> a = new ArrayList<>();
        for (String email : treeSet) {
            System.out.println(email);
            a.add(email);
        }
        return a;
    }
}
