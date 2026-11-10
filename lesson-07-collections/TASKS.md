# Задания к Уроку 7

## Задание 1. Уникальные слова
Пользователь вводит строку текста (предложение). Разбейте её на слова и сохраните в `Set`, чтобы убрать дубликаты. Выведите количество уникальных слов и сами слова.

**Решение:**

~~~java
package lesson07;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите предложение: ");
        String text = scanner.nextLine();

        // Разбиваем по пробелам и приводим к нижнему регистру для корректного сравнения
        String[] words = text.toLowerCase().split("\\s+");
        
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
        
        System.out.println("Количество уникальных слов: " + uniqueWords.size());
        System.out.println("Уникальные слова: " + uniqueWords);
        
        scanner.close();
    }
}
~~~

---

## Задание 2. Телефонная книга
Создайте `Map<String, String>`, где ключ — имя, а значение — номер телефона. 
Добавьте 3 записи. Выведите номер по имени, а также проверьте наличие номера для имени, которого нет в словаре.

**Решение:**

~~~java
package lesson07;

import java.util.HashMap;
import java.util.Map;

public class Task2 {
    public static void main(String[] args) {
        Map<String, String> phoneBook = new HashMap<>();
        
        phoneBook.put("Иван", "+7-900-123-45-67");
        phoneBook.put("Мария", "+7-900-765-43-21");
        phoneBook.put("Петр", "+7-900-555-55-55");

        System.out.println("Номер Ивана: " + phoneBook.get("Иван"));
        
        String unknownName = "Анна";
        if (phoneBook.containsKey(unknownName)) {
            System.out.println("Номер " + unknownName + ": " + phoneBook.get(unknownName));
        } else {
            System.out.println("Номер для " + unknownName + " не найден.");
        }
    }
}
~~~

---

## Задание 3. Подсчет частоты слов
Пользователь вводит текст. Подсчитайте, сколько раз встречается каждое слово, и выведите результат в формате `слово: количество`. 
*Подсказка:* используйте `Map<String, Integer>`. Если слово уже есть в словаре, увеличьте его счетчик на 1.

**Решение:**

~~~java
package lesson07;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите текст: ");
        String text = scanner.nextLine();

        String[] words = text.toLowerCase().split("\\s+");
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            // Если слово уже есть, берем текущее значение и +1. Иначе 0 + 1.
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        System.out.println("\nЧастота слов:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        scanner.close();
    }
}
~~~

---

## Задание 4 (*). Класс в HashSet
Создайте класс `Book` с полями `title` и `author` (оба `String`). Переопределите в нём `equals()` и `hashCode()` так, чтобы две книги считались одинаковыми, если у них совпадает название и автор.
Создайте `HashSet<Book>`, добавьте две одинаковые книги и проверьте, что в множестве осталась только одна.

**Решение:**

~~~java
package lesson07;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }

    @Override
    public String toString() {
        return title + " (" + author + ")";
    }
}

public class Task4 {
    public static void main(String[] args) {
        Set<Book> library = new HashSet<>();
        
        library.add(new Book("Война и мир", "Лев Толстой"));
        library.add(new Book("Война и мир", "Лев Толстой")); // Дубликат
        library.add(new Book("Анна Каренина", "Лев Толстой")); // Другая книга

        System.out.println("Количество книг в множестве: " + library.size()); // Будет 2
        System.out.println(library);
    }
}
~~~