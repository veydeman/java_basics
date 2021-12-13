import java.util.Scanner;


public class Main {
    private static TodoList todoList = new TodoList();
    private static final String ADD_REGEX = "(add|ADD|Add)\\p{Space}\\p{Alpha}+";
    private static final String ADD_INDEX_REGEX = "(add|ADD|Add)\\p{Space}\\p{Digit}+\\p{Space}\\p{Alpha}+";
    private static final String LIST_REGEX = "list|LIST|List";
    private static final String DELETE_REGEX = "(delete|DELETE|Delete)\\p{Space}.*";
    private static final String EDIT_REGEX = "(edit|EDIT|Edit)\\p{Space}\\p{Digit}+\\p{Space}\\p{Alpha}+";

    public static void main(String[] args) {
        while (true) {
            Scanner in = new Scanner(System.in);
            String a = in.nextLine();


            if (a.matches(ADD_REGEX)) {
                todoList.add(a.substring(4));
            }
            if (a.matches(ADD_INDEX_REGEX)) {
                todoList.add(Integer.parseInt(a.substring(4, 5)), a.substring(6));
            }
            if (a.matches(LIST_REGEX)) {
                todoList.getTodos();
            }
            if (a.matches(DELETE_REGEX)) {
                todoList.delete(Integer.parseInt(a.substring(7)));
            }
            if (a.matches(EDIT_REGEX)) {
                todoList.edit(a.substring(7), Integer.parseInt(a.substring(5, 6)));
            }
        }
    }

    // TODO: написать консольное приложение для работы со списком дел todoList
}

