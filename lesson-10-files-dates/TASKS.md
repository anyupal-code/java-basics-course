# Задания к Уроку 10

## Задание 1. Запись и чтение списка дел
Напишите программу, которая:
1. Создает список строк (например, список покупок).
2. Записывает его в файл `shopping.txt`.
3. Читает файл и выводит каждую строку с префиксом "Куплено: ".

**Решение:**

~~~java
package lesson10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        Path path = Paths.get("shopping.txt");
        List<String> items = List.of("Хлеб", "Молоко", "Яблоки");

        try {
            // Запись
            Files.write(path, items);
            System.out.println("Список сохранен.");

            // Чтение
            List<String> readItems = Files.readAllLines(path);
            for (String item : readItems) {
                System.out.println("Куплено: " + item);
            }
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
~~~

---

## Задание 2. Возраст пользователя
Пользователь вводит свою дату рождения в формате `dd.MM.yyyy` (например, `15.05.1990`).
Вычислите и выведите его полный возраст (количество полных лет) на текущую дату.

**Решение:**

~~~java
package lesson10;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите дату рождения (dd.MM.yyyy): ");
        String input = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        try {
            LocalDate birthDate = LocalDate.parse(input, formatter);
            LocalDate today = LocalDate.now();

            Period age = Period.between(birthDate, today);
            System.out.println("Ваш возраст: " + age.getYears() + " лет.");
        } catch (Exception e) {
            System.out.println("Некорректный формат даты!");
        }
        
        scanner.close();
    }
}
~~~

---

## Задание 3. Дедлайн проекта
Напишите программу, которая вычисляет, сколько дней осталось до заданной даты (например, до 31 декабря 2026 года).
Если дата уже прошла, выведите сообщение "Срок истек".

**Решение:**

~~~java
package lesson10;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Task3 {
    public static void main(String[] args) {
        LocalDate deadline = LocalDate.of(2026, 12, 31);
        LocalDate today = LocalDate.now();

        if (today.isAfter(deadline)) {
            System.out.println("Срок истек");
        } else {
            long daysLeft = ChronoUnit.DAYS.between(today, deadline);
            System.out.println("До дедлайна осталось дней: " + daysLeft);
        }
    }
}
~~~

---

## Задание 4 (*). Дневник
Создайте программу, которая при запуске запрашивает у пользователя текст записи (одну строку) и текущую дату. 
Затем добавляет эту запись в конец файла `diary.txt` в формате: `[yyyy-MM-dd] Текст записи`.

**Решение:**

~~~java
package lesson10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Path path = Paths.get("diary.txt");
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите запись в дневник: ");
        String text = scanner.nextLine();
        
        String logEntry = "[" + LocalDate.now() + "] " + text;
        
        try {
            // StandardOpenOption.APPEND добавляет в конец файла, а не перезаписывает его
            Files.writeString(path, logEntry + System.lineSeparator(), 
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            System.out.println("Запись добавлена.");
        } catch (IOException e) {
            System.out.println("Ошибка при записи: " + e.getMessage());
        }
        
        scanner.close();
    }
}
~~~