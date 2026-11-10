# Задания к Уроку 6

## Задание 1. Безопасное деление
Напишите программу, которая запрашивает у пользователя два целых числа и делит первое на второе. 
Обработайте исключение `ArithmeticException` (деление на ноль) и `InputMismatchException` (если введена буква вместо числа).

**Решение:**

~~~java
package lesson06;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите первое число: ");
            int a = scanner.nextInt();
            
            System.out.print("Введите второе число: ");
            int b = scanner.nextInt();
            
            int result = a / b;
            System.out.println("Результат: " + result);
            
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: деление на ноль!");
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: вы ввели не целое число!");
        } finally {
            System.out.println("Завершение работы программы.");
            scanner.close();
        }
    }
}
~~~

---

## Задание 2. Валидация пароля
Напишите метод `checkPassword(String password)`, который выбрасывает собственное исключение `WeakPasswordException`, если длина пароля меньше 8 символов.
В `main` вызовите метод с коротким паролем и обработайте исключение.

**Решение:**

~~~java
package lesson06;

public class WeakPasswordException extends Exception {
    public WeakPasswordException(String message) {
        super(message);
    }
}
~~~

~~~java
package lesson06;

public class Task2 {
    public static void checkPassword(String password) throws WeakPasswordException {
        if (password.length() < 8) {
            throw new WeakPasswordException("Пароль слишком короткий! Минимум 8 символов.");
        }
        System.out.println("Пароль надежный.");
    }

    public static void main(String[] args) {
        String myPassword = "12345";

        try {
            checkPassword(myPassword);
        } catch (WeakPasswordException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
~~~

---

## Задание 3 (*). Безопасный поиск в массиве
Дан массив `int[] arr = {10, 20, 30}`. Напишите программу, которая запрашивает у пользователя индекс и выводит значение по этому индексу. 
Обработайте `ArrayIndexOutOfBoundsException` и `InputMismatchException`. Если ошибка произошла, программа должна попросить ввести индекс заново (используйте цикл `while`).

**Решение:**

~~~java
package lesson06;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30};
        Scanner scanner = new Scanner(System.in);
        boolean success = false;

        while (!success) {
            try {
                System.out.print("Введите индекс массива (0-2): ");
                int index = scanner.nextInt();
                System.out.println("Значение: " + arr[index]);
                success = true; // Если дошли сюда, значит ошибки не было
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Ошибка: такого индекса нет. Попробуйте снова.");
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: нужно ввести целое число.");
                scanner.nextLine(); // Очищаем буфер сканера от неверного ввода
            }
        }
        scanner.close();
    }
}
~~~