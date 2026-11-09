package lesson03;

public class ArraysExample {
    public static void main(String[] args) {
        // Создание массива с инициализацией
        int[] primes = {2, 3, 5, 7, 11};
        String[] names = {"Иван", "Мария", "Петр"};

        // Доступ по индексу
        System.out.println("Первый элемент: " + primes[0]); 
        System.out.println("Последний элемент: " + primes[primes.length - 1]);

        // Перебор через обычный for
        System.out.println("\nПеребор через for:");
        for (int i = 0; i < primes.length; i++) {
            System.out.println("Индекс " + i + ": " + primes[i]);
        }

        // Перебор через for-each
        System.out.println("\nПеребор через for-each:");
        for (String name : names) {
            System.out.println(name);
        }
    }
}