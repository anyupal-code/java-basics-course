package lesson07;

import java.util.ArrayList;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        // Создаем список строк
        List<String> names = new ArrayList<>();
        
        names.add("Иван");
        names.add("Мария");
        names.add("Иван"); // Дубликаты разрешены

        System.out.println("Первый элемент: " + names.get(0));
        System.out.println("Размер списка: " + names.size());
        System.out.println("Содержит 'Мария': " + names.contains("Мария"));

        // Перебор через for-each
        System.out.println("\nВсе имена:");
        for (String name : names) {
            System.out.println(name);
        }

        // Удаление элемента
        names.remove("Иван"); // Удалит только первое вхождение
        System.out.println("\nПосле удаления 'Иван': " + names);
    }
}