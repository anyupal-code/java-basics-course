package lesson08;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Иван", "Мария", "Петр", "Анна");

        // 1. Consumer: принимает значение, ничего не возвращает
        Consumer<String> printer = name -> System.out.println("Имя: " + name);
        names.forEach(printer);

        System.out.println("\n---");

        // 2. Predicate: проверяет условие, возвращает boolean
        Predicate<String> startsWithA = name -> name.startsWith("А");
        names.stream()
             .filter(startsWithA)
             .forEach(name -> System.out.println("Начинается на А: " + name));

        System.out.println("\n---");

        // 3. Function: преобразует одно значение в другое
        Function<String, Integer> lengthFunction = name -> name.length();
        for (String name : names) {
            System.out.println(name + " имеет длину " + lengthFunction.apply(name));
        }
    }
}