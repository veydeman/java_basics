import java.util.*;
import java.util.Map;
import java.util.TreeSet;

public class PhoneBook {

    public static final String PHONE_PATTERN = "\\d{11}";
    public static final String NAME_PATTERN = "\\p{IsAlphabetic}+";

    TreeMap<String, String> phoneList = new TreeMap<>();

    public void addContact(String phone, String name) {
        if (phone.matches(PHONE_PATTERN) && name.matches(NAME_PATTERN)) {
            if (phoneList.containsValue(phone)) {
                for (Map.Entry<String, String> entry : phoneList.entrySet()) {
                    if (entry.getValue().equals(phone)) {
                        String key = entry.getKey();
                        phoneList.remove(key, phone);
                    }
                }
                phoneList.put(name, phone);
            } else if (phoneList.containsKey(name)) {
                String num;
                num = phoneList.get(name).concat(", ").concat(phone);
                phoneList.put(name, num);
            } else {
                if (phone.matches(PHONE_PATTERN) && name.matches(NAME_PATTERN))
                    phoneList.put(name, phone);
                else System.out.println("Неверный формат ввода");
            }
        } else if (phone.matches(PHONE_PATTERN) ^ name.matches(NAME_PATTERN)) {
            if (phoneList.containsValue(phone)) {
                for (Map.Entry<String, String> entry : phoneList.entrySet()) {
                    if (entry.getValue().equals(phone)) {
                        String key = entry.getKey();
                        phoneList.remove(key, phone);
                    }
                }
                phoneList.put(name, phone);
            } else if (phoneList.containsKey(name)) {
                String num;
                num = phoneList.get(name).concat(", ").concat(phone);
                phoneList.put(name, num);
            } else {
                if (phone.matches(PHONE_PATTERN) && name.matches(NAME_PATTERN))
                    phoneList.put(name, phone);
                else System.out.println("Неверный формат ввода");
            }
        } else if (phone.matches(PHONE_PATTERN) || name.matches(NAME_PATTERN)) {
            if (phoneList.containsValue(phone)) {
                for (Map.Entry<String, String> entry : phoneList.entrySet()) {
                    if (entry.getValue().equals(phone)) {
                        String key = entry.getKey();
                        phoneList.remove(key, phone);
                    }
                }
                phoneList.put(name, phone);
            } else if (phoneList.containsKey(name)) {
                String num;
                num = phoneList.get(name).concat(", ").concat(phone);
                phoneList.put(name, num);
            } else {
                if (phone.matches(PHONE_PATTERN) && name.matches(NAME_PATTERN))
                    phoneList.put(name, phone);
                else System.out.println("Неверный формат ввода");
            }
        }
    }

    public String getContactByPhone(String phone) {
        String d = "";
        for (Map.Entry<String, String> item : phoneList.entrySet()) {
            if (Objects.equals(item.getValue(), phone)) {
                d = item.getKey();
                System.out.println(d + " - " + phone);
            }
        }
        return d + " - " + phone;
    }

    public Set<String> getContactByName(String name) {
        TreeSet<String> getContact = new TreeSet<>();
        getContact.add(name + " - " + phoneList.get(name));
        System.out.println(getContact);
        return getContact;
    }

    public TreeSet<String> getAllContacts() {
        TreeSet<String> contacts = new TreeSet<>();
        for (Map.Entry<String, String> item : phoneList.entrySet()) {
            System.out.println("Имя: " + item.getKey() + " | Номер: " + item.getValue());
            contacts.add(item.getKey() + " - " + item.getValue());
        }
        return contacts;
    }
}