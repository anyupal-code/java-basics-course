package lesson09;

import java.util.List;
import java.util.stream.Collectors;

public class StreamBasics {
    public static void main(String[] args) {
        List<String> names = List.of("Иван", "Мария", "Петр", "Анна", "Игорь");

        System.out.println("--- Исходный список ---");
        System.out.println(names);

        System.out.println("\n--- Фильтрация (только имена на 'И') ---");
        names.stream()
             .filter(name -> name.startsWith("И"))
             .forEach(System.out::println);

        System.out.println("\n--- Преобразование (в верхний регистр) и сбор в список ---");
        List<String> upperNames = names.stream()
                                       .map(String::toUpperCase)
                                       .collect(Collectors.toList());
        System.out.println(upperNames);

        System.out.println("\n--- Подсчет количества имен длиннее 4 символов ---");
        long count = names.stream()
                          .filter(name -> name.length() > 4)
                          .count();
        System.out.println("Найдено: " + count);
    }
}