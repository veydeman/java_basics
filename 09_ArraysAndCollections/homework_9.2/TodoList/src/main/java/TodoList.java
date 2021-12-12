import java.util.ArrayList;


public class TodoList {
    ArrayList<String> array = new ArrayList<>();


    public void add(String todo) {
        array.add(todo);
        System.out.println("Добавлено дело " + "\"" + array.get(array.size() - 1) + "\"");
        // TODO: добавьте переданное дело в конец списка
    }

    public void add(int index, String todo) {
        if (index > array.size()) {
            array.add(todo);
            System.out.println("Добавлено дело " + "\"" + array.get(array.size() - 1) + "\"");
            return;
        }
        array.add(index, todo);
        System.out.println("Добавлено дело " + "\"" + array.get(index) + "\"");
        // TODO: добавьте дело на указаный индекс,
        //  проверьте возможность добавления
    }

    public void edit(String todo, int index) {
        if (index > array.size()) {
            System.out.println("Неверный индекс");
            return;
        } else
            System.out.print("Дело " + "\"" + array.get(index) + "\"" + " заменено на ");
        array.set(index, todo);
        System.out.println("\"" + array.get(index) + "\"");
        // TODO: заменить дело на index переданным todo индекс,
        //  проверьте возможность изменения
    }

    public void delete(int index) {
        if (index >= array.size()) {
            System.out.println("Дело с таким номером не существует");
            return;
        } else
            System.out.println("Дело " + "\"" + array.get(index) + "\"" + " удалено");
        array.remove(index);
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела
    }

    public ArrayList<String> getTodos() {
        // TODO: вернуть список дел
        for (int i = 0; i < array.size(); i++) {
            System.out.println(i + " - " + array.get(i));
        }
        return array;
    }
}