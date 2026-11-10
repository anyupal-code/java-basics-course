package lesson07;

import java.util.HashSet;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        Set<String> uniqueNames = new HashSet<>();
        
        uniqueNames.add("Иван");
        uniqueNames.add("Мария");
        uniqueNames.add("Иван"); // Дубликат не добавится

        System.out.println("Размер множества: " + uniqueNames.size());
        
        System.out.println("Содержит 'Иван': " + uniqueNames.contains("Иван"));
        
        System.out.println("\nВсе имена (порядок может быть случайным):");
        for (String name : uniqueNames) {
            System.out.println(name);
        }
    }
}