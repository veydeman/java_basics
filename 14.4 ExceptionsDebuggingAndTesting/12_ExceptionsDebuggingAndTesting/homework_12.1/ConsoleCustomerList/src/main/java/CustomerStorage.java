import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        String[] components = data.split("\\s+");
        if (components.length > 4) {
            throw new IllegalArgumentException("Передано более 4 слов в строке");
        } else if (components.length < 4) {
            throw new IllegalArgumentException("Передано менее 4 слов в строке");
        } else if (!components[INDEX_EMAIL].matches("(\\w+)@(\\w+\\.\\w+)")) {
            throw new IllegalArgumentException("Неверный формат email");
        } else if (!components[INDEX_PHONE].matches("\\+\\p{Digit}{11}")) {
            throw new IllegalArgumentException("Неверный формат номера");
        }
        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}