# Задания к Уроку 9

## Задание 1. Фильтрация и преобразование
Дан список строк: `List<String> words = Arrays.asList("java", "python", "c++", "javascript", "go");`
Используя Stream API:
1. Оставьте только слова, длина которых больше 3 символов.
2. Преобразуйте их в верхний регистр.
3. Соберите результат в новый список и выведите его.

**Решение:**

~~~java
package lesson09;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("java", "python", "c++", "javascript", "go");

        List<String> result = words.stream()
                                   .filter(word -> word.length() > 3)
                                   .map(String::toUpperCase)
                                   .collect(Collectors.toList());

        System.out.println(result);
    }
}
~~~

---

## Задание 2. Сумма четных чисел
Дан список целых чисел: `List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);`
Найдите сумму всех четных чисел с помощью Stream API (используйте `filter` и `reduce` или `mapToInt`).

**Решение:**

~~~java
package lesson09;

import java.util.Arrays;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int sum = numbers.stream()
                         .filter(n -> n % 2 == 0)
                         .mapToInt(Integer::intValue)
                         .sum();

        System.out.println("Сумма четных чисел: " + sum);
    }
}
~~~

---

## Задание 3. Поиск максимального элемента
Дан список строк. Найдите самое длинное слово с помощью Stream API.
*Подсказка:* используйте `max(Comparator.comparingInt(String::length))`.

**Решение:**

~~~java
package lesson09;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Task3 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("java", "python", "c++", "javascript", "go");

        Optional<String> longest = words.stream()
                                        .max(Comparator.comparingInt(String::length));

        longest.ifPresent(word -> System.out.println("Самое длинное слово: " + word));
    }
}
~~~

---

## Задание 4 (*). Группировка студентов по возрасту
Создайте класс `Student` с полями `name` (String) и `age` (int). 
Создайте список из нескольких студентов. 
Сгруппируйте их по возрасту в `Map<Integer, List<Student>>` с помощью `Collectors.groupingBy()` и выведите результат.

**Решение:**

~~~java
package lesson09;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() { return age; }

    @Override
    public String toString() { return name; }
}

public class Task4 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Иван", 20),
            new Student("Мария", 22),
            new Student("Петр", 20),
            new Student("Анна", 22),
            new Student("Олег", 21)
        );

        Map<Integer, List<Student>> byAge = students.stream()
            .collect(Collectors.groupingBy(Student::getAge));

        byAge.forEach((age, list) -> 
            System.out.println(age + " лет: " + list)
        );
    }
}
~~~