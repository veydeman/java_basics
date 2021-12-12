import java.util.Scanner;


public class Main {
    private static TodoList todoList = new TodoList();
    private static final String addRegex = "(add|ADD|Add)\\p{Space}\\p{Alpha}+";
    private static final String addIndexRegex = "(add|ADD|Add)\\p{Space}\\p{Digit}+\\p{Space}\\p{Alpha}+";
    private static final String listRegex = "list|LIST|List";
    private static final String deleteRegex = "(delete|DELETE|Delete)\\p{Space}.*";
    private static final String editRegex = "(edit|EDIT|Edit)\\p{Space}\\p{Digit}+\\p{Space}\\p{Alpha}+";

    public static void main(String[] args) {
        while (true) {
            Scanner in = new Scanner(System.in);
            String a = in.nextLine();


            if (a.matches(addRegex)) {
                todoList.add(a.substring(4));
            }
            if (a.matches(addIndexRegex)) {
                todoList.add(Integer.parseInt(a.substring(4, 5)), a.substring(6));
            }
            if (a.matches(listRegex)) {
                todoList.getTodos();
            }
            if (a.matches(deleteRegex)) {
                todoList.delete(Integer.parseInt(a.substring(7)));
            }
            if (a.matches(editRegex)) {
                todoList.edit(a.substring(7), Integer.parseInt(a.substring(5, 6)));
            }
        }
    }

    // TODO: написать консольное приложение для работы со списком дел todoList
}

