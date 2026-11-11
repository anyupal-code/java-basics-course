# Урок 10. Работа с файлами и датами

## Цель урока
Научиться читать и записывать данные в файлы с помощью `java.nio`, а также освоить современный API для работы с датами и временем (`java.time`).

---

## Теория

### 1. Пакет java.nio.file
Для работы с файлами в современной Java используется пакет `java.nio.file` (вместо устаревшего `java.io.File`).
Основные классы:
* `Path` — путь к файлу или папке.
* `Files` — утилитарный класс с методами для чтения, записи и проверки файлов.

### 2. Чтение файла
Самый простой способ прочитать текстовый файл целиком — `Files.readAllLines()`.
Он возвращает список строк.

~~~java
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;

public class ReadExample {
    public static void main(String[] args) {
        Path path = Paths.get("data.txt");
        try {
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
~~~

**Важно:** операции с файлами выбрасывают `IOException` (checked exception), поэтому их нужно оборачивать в `try-catch` или добавлять `throws IOException` в сигнатуру метода.

### 3. Запись в файл
Для записи используется `Files.write()`.

~~~java
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;

public class WriteExample {
    public static void main(String[] args) {
        Path path = Paths.get("output.txt");
        List<String> lines = List.of("Первая строка", "Вторая строка", "Третья строка");
        
        try {
            Files.write(path, lines);
            System.out.println("Файл успешно записан.");
        } catch (IOException e) {
            System.out.println("Ошибка при записи: " + e.getMessage());
        }
    }
}
~~~

### 4. Проверка существования и создание
* `Files.exists(path)` — проверяет, существует ли файл.
* `Files.createFile(path)` — создает пустой файл (если его нет).
* `Files.createDirectories(path)` — создает папки (включая родительские).

### 5. Пакет java.time
Старый класс `java.util.Date` устарел. В современной Java используется `java.time`.

Основные классы:
* `LocalDate` — дата (год, месяц, день) без времени.
* `LocalTime` — время (часы, минуты, секунды) без даты.
* `LocalDateTime` — дата и время вместе.
* `Duration` — промежуток времени между двумя моментами.
* `Period` — промежуток между двумя датами (в годах, месяцах, днях).

### 6. Создание и получение данных
~~~java
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class DateExample {
    public static void main(String[] args) {
        // Текущая дата
        LocalDate today = LocalDate.now();
        System.out.println("Сегодня: " + today);

        // Конкретная дата
        LocalDate specificDate = LocalDate.of(2026, Month.NOVEMBER, 11);
        System.out.println("Дата: " + specificDate);

        // Текущее время
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Сейчас: " + now);

        // Получение компонентов даты
        System.out.println("Год: " + today.getYear());
        System.out.println("Месяц: " + today.getMonth());
        System.out.println("День: " + today.getDayOfMonth());
    }
}
~~~

### 7. Арифметика дат
Классы `java.time` неизменяемы: методы возвращают новый объект, а не меняют старый.

~~~java
LocalDate today = LocalDate.now();
LocalDate nextWeek = today.plusWeeks(1);   // +1 неделя
LocalDate yesterday = today.minusDays(1);  // -1 день

System.out.println("Через неделю: " + nextWeek);
System.out.println("Вчера: " + yesterday);
~~~

### 8. Разница между датами
~~~java
import java.time.LocalDate;
import java.time.Period;

LocalDate start = LocalDate.of(2026, 1, 1);
LocalDate end = LocalDate.of(2026, 12, 31);

Period period = Period.between(start, end);
System.out.println("Разница: " + period.getMonths() + " месяцев и " + period.getDays() + " дней");
~~~

### 9. Форматирование дат
Для форматирования используется `DateTimeFormatter`.

~~~java
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

LocalDate date = LocalDate.of(2026, 11, 11);
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
System.out.println(date.format(formatter)); // 11.11.2026
~~~

---

## Практика
Примеры кода для запуска лежат в папке `src/lesson10/`:
* `FileReadWrite.java` — чтение и запись файла.
* `DateTimeExample.java` — работа с датами, арифметика и форматирование.

Переходите к [Заданиям](TASKS.md) для самостоятельной работы.

---

## Чек-лист
- [ ] Умею читать файл через `Files.readAllLines()`.
- [ ] Умею записывать файл через `Files.write()`.
- [ ] Понимаю, зачем нужен `try-catch` при работе с файлами.
- [ ] Умею создавать даты через `LocalDate` и `LocalDateTime`.
- [ ] Умею прибавлять/вычитать дни и вычислять разницу между датами.
- [ ] Умею форматировать дату через `DateTimeFormatter`.

---

## Что дальше
На следующем уроке разберём **Введение в Git и работу с проектами**.