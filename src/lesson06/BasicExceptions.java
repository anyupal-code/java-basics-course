package lesson06;
//Стандартные исключения и блоки try-catch-finally
import java.util.InputMismatchException;
import java.util.Scanner;

public class BasicExceptions {
    public static void main(String[] args) {
        System.out.println("--- Пример 1: Деление на ноль ---");
        try {
            int result = 10 / 0;
            System.out.println("Результат: " + result); // Эта строка не выполнится
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: деление на ноль! (" + e.getMessage() + ")");
        }

        System.out.println("\n--- Пример 2: Выход за границы массива ---");
        int[] numbers = {1, 2, 3};
        try {
            System.out.println(numbers[5]); // Индекс 5 не существует
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: индекс вне границ массива!");
        }

        System.out.println("\n--- Пример 3: Ввод с клавиатуры (finally) ---");
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите целое число: ");
            int num = scanner.nextInt();
            System.out.println("Вы ввели: " + num);
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: вы ввели не число!");
        } finally {
            System.out.println("Блок finally: выполнится в любом случае.");
            scanner.close();
        }
    }
}