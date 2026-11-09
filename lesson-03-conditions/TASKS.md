# Задания к Уроку 3

## Задание 1. Четное или нечетное
Пользователь вводит целое число. Напишите программу, которая проверяет, является ли оно четным, и выводит соответствующее сообщение.

**Решение:**

    package lesson03;

    import java.util.Scanner;

    public class Task1 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            
            System.out.print("Введите число: ");
            int number = scanner.nextInt();
            
            if (number % 2 == 0) {
                System.out.println("Число четное");
            } else {
                System.out.println("Число нечетное");
            }
            
            scanner.close();
        }
    }

---

## Задание 2. Оценка по баллам
Пользователь вводит количество баллов (от 0 до 100). Программа должна вывести оценку:
* 90-100: "Отлично"
* 70-89: "Хорошо"
* 50-69: "Удовлетворительно"
* 0-49: "Неудовлетворительно"

**Решение:**

    package lesson03;

    import java.util.Scanner;

    public class Task2 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            
            System.out.print("Введите баллы: ");
            int score = scanner.nextInt();
            
            if (score >= 90 && score <= 100) {
                System.out.println("Отлично");
            } else if (score >= 70 && score < 90) {
                System.out.println("Хорошо");
            } else if (score >= 50 && score < 70) {
                System.out.println("Удовлетворительно");
            } else if (score >= 0 && score < 50) {
                System.out.println("Неудовлетворительно");
            } else {
                System.out.println("Некорректный ввод");
            }
            
            scanner.close();
        }
    }

---

## Задание 3. Сумма чисел от 1 до N
Пользователь вводит число N. Используя цикл `for`, найдите сумму всех чисел от 1 до N.

**Решение:**

    package lesson03;

    import java.util.Scanner;

    public class Task3 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            
            System.out.print("Введите N: ");
            int n = scanner.nextInt();
            
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += i;
            }
            
            System.out.println("Сумма от 1 до " + n + " равна: " + sum);
            
            scanner.close();
        }
    }

---

## Задание 4 (*). Поиск максимального элемента в массиве
Создайте массив из 5 целых чисел (заполните его самостоятельно). Найдите и выведите максимальный элемент.

**Решение:**

    package lesson03;

    public class Task4 {
        public static void main(String[] args) {
            int[] numbers = {12, 45, 7, 89, 23};
            
            int max = numbers[0];
            for (int i = 1; i < numbers.length; i++) {
                if (numbers[i] > max) {
                    max = numbers[i];
                }
            }
            
            System.out.println("Максимальный элемент: " + max);
        }
    }