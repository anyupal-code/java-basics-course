package lesson07;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        // Ключ - String, Значение - Integer
        Map<String, Integer> ages = new HashMap<>();
        
        ages.put("Иван", 25);
        ages.put("Мария", 30);
        ages.put("Иван", 26); // Значение перезапишется

        System.out.println("Возраст Ивана: " + ages.get("Иван"));
        System.out.println("Содержит ключ 'Мария': " + ages.containsKey("Мария"));
        System.out.println("Размер словаря: " + ages.size());

        // Перебор всех пар ключ-значение
        System.out.println("\nВсе записи:");
        for (Map.Entry<String, Integer> entry : ages.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}