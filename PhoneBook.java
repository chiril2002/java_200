import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        HashMap<String, HashSet<String>> phoneBook = new HashMap<>();

        // Пример входных данных
        addContact(phoneBook, "Иванов", "1234567890");
        addContact(phoneBook, "Петров", "9876543210");
        addContact(phoneBook, "Сидоров", "5555555555");
        addContact(phoneBook, "Иванов", "9998887776");
        addContact(phoneBook, "Петров", "1112223334");

        // Вывод телефонной книги
        printPhoneBook(phoneBook);
    }

    // Метод для добавления контакта в телефонную книгу
    public static void addContact(HashMap<String, HashSet<String>> phoneBook, String name, String phoneNumber) {
        // Если имя уже существует в телефонной книге, добавляем номер к существующему списку номеров
        if (phoneBook.containsKey(name)) {
            HashSet<String> phoneNumbers = phoneBook.get(name);
            phoneNumbers.add(phoneNumber);
        } else {
            // Если имя не существует, создаем новую запись в телефонной книге
            HashSet<String> phoneNumbers = new HashSet<>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(name, phoneNumbers);
        }
    }

    // Метод для вывода телефонной книги, отсортированной по убыванию числа телефонов
    public static void printPhoneBook(HashMap<String, HashSet<String>> phoneBook) {
        // Создаем список записей (имя - список номеров) из элементов HashMap
        List<Map.Entry<String, HashSet<String>>> entries = new ArrayList<>(phoneBook.entrySet());

        // Сортируем список по убыванию числа телефонов
        Collections.sort(entries, new Comparator<Map.Entry<String, HashSet<String>>>() {
            @Override
            public int compare(Map.Entry<String, HashSet<String>> o1, Map.Entry<String, HashSet<String>> o2) {
                return Integer.compare(o2.getValue().size(), o1.getValue().size());
            }
        });

        // Выводим отсортированные записи
        for (Map.Entry<String, HashSet<String>> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
