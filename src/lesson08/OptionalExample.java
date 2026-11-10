package lesson08;

import java.util.Optional;

public class OptionalExample {
    
    // Метод, который может вернуть null
    public static String findNameById(int id) {
        if (id == 1) return "Иван";
        if (id == 2) return "Мария";
        return null;
    }

    public static void main(String[] args) {
        // Пример 1: значение есть
        Optional<String> name1 = Optional.ofNullable(findNameById(1));
        System.out.println("Найдено: " + name1.orElse("Не найдено"));

        // Пример 2: значение отсутствует
        Optional<String> name2 = Optional.ofNullable(findNameById(99));
        
        // Безопасная проверка на наличие значения
        if (name2.isPresent()) {
            System.out.println("Имя: " + name2.get());
        } else {
            System.out.println("Пользователь с таким ID не найден.");
        }

        // Пример 3: ifPresentOrElse
        name2.ifPresentOrElse(
            n -> System.out.println("Имя: " + n),
            () -> System.out.println("Пусто (ifPresentOrElse)")
        );

        // Пример 4: значение по умолчанию
        String result = name2.orElse("Значение по умолчанию");
        System.out.println("Результат: " + result);
    }
}