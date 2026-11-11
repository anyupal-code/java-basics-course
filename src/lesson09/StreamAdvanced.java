package lesson09;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamAdvanced {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(5, 2, 8, 1, 9, 3, 7);

        System.out.println("--- Сортировка ---");
        List<Integer> sorted = numbers.stream()
                                      .sorted()
                                      .collect(Collectors.toList());
        System.out.println("По возрастанию: " + sorted);

        System.out.println("\n--- Ограничение (limit) ---");
        numbers.stream()
               .limit(3)
               .forEach(n -> System.out.print(n + " "));
        System.out.println();

        System.out.println("\n--- Reduce (сумма всех чисел) ---");
        int sum = numbers.stream()
                         .reduce(0, Integer::sum);
        System.out.println("Сумма: " + sum);

        System.out.println("\n--- Группировка по четности ---");
        Map<Boolean, List<Integer>> byEven = numbers.stream()
            .collect(Collectors.groupingBy(n -> n % 2 == 0));
        
        System.out.println("Четные: " + byEven.get(true));
        System.out.println("Нечетные: " + byEven.get(false));
    }
}