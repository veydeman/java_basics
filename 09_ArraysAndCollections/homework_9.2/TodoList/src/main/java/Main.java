import java.util.Scanner;


public class Main {
    private static TodoList todoList = new TodoList();


    public static void main(String[] args) {
        while (true) {
            Scanner in = new Scanner(System.in);
            String a = in.nextLine();


            if (a.matches("(add|ADD|Add)\\p{Space}\\p{Alpha}+")) {
                todoList.add(a.substring(4));
            }
            if (a.matches("(add|ADD|Add)\\p{Space}\\p{Digit}+\\p{Space}\\p{Alpha}+")) {
                todoList.add(Integer.parseInt(a.substring(4, 5)), a.substring(6));
            }
            if (a.matches("list|LIST|List")) {
                todoList.getTodos();
            }
            if (a.matches("(delete|DELETE|Delete)\\p{Space}.*")) {
                todoList.delete(Integer.parseInt(a.substring(7)));
            }
            if (a.matches("(edit|EDIT|Edit)\\p{Space}\\p{Digit}+\\p{Space}\\p{Alpha}+")) {
                todoList.edit(a.substring(7), Integer.parseInt(a.substring(5, 6)));
            }
        }
    }

    // TODO: написать консольное приложение для работы со списком дел todoList
}

