# Задания к Уроку 8

## Задание 1. Обобщенная пара
Создайте обобщенный класс `Pair<K, V>`, который хранит два значения: ключ и значение. 
Добавьте методы `getKey()`, `getValue()` и `setKey()`, `setValue()`. 
Создайте объект `Pair<String, Integer>` и продемонстрируйте работу его методов.

**Решение:**

~~~java
package lesson08;

public class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() { return key; }
    public void setKey(K key) { this.key = key; }

    public V getValue() { return value; }
    public void setValue(V value) { this.value = value; }

    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("Возраст", 25);
        System.out.println(pair.getKey() + ": " + pair.getValue());
        
        pair.setValue(26);
        System.out.println("Новое значение: " + pair.getValue());
    }
}
~~~

---

## Задание 2. Фильтрация списка с лямбдой
Дан список строк: `List<String> words = Arrays.asList("Java", "Python", "C++", "JavaScript", "Go");`
Используя лямбда-выражение и метод `forEach()`, выведите на экран только те слова, длина которых больше 3 символов.

**Решение:**

~~~java
package lesson08;

import java.util.Arrays;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java", "Python", "C++", "JavaScript", "Go");
        
        words.forEach(word -> {
            if (word.length() > 3) {
                System.out.println(word);
            }
        });
    }
}
~~~

---

## Задание 3. Безопасный парсинг числа
Напишите метод `parseIntSafe(String input)`, который возвращает `Optional<Integer>`. 
Если строка содержит корректное число, метод возвращает `Optional.of(число)`. 
Если строку невозможно преобразовать в число (например, "abc"), метод возвращает `Optional.empty()`.
В `main` проверьте работу метода на корректной и некорректной строке.

**Решение:**

~~~java
package lesson08;

import java.util.Optional;

public class Task3 {
    
    public static Optional<Integer> parseIntSafe(String input) {
        try {
            return Optional.of(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    public static void main(String[] args) {
        Optional<Integer> num1 = parseIntSafe("123");
        System.out.println("Результат 1: " + num1.orElse(-1));

        Optional<Integer> num2 = parseIntSafe("abc");
        System.out.println("Результат 2: " + num2.orElse(-1));
        
        // Или через ifPresent
        num1.ifPresent(n -> System.out.println("Число: " + n));
    }
}
~~~

---

## Задание 4 (*). Своя функция
Создайте функциональный интерфейс `Calculator` с одним методом `int calculate(int a, int b)`. 
Используя лямбда-выражения, создайте три реализации: для сложения, вычитания и умножения. 
Продемонстрируйте их работу в `main`.

**Решение:**

~~~java
package lesson08;

public class Task4 {
    
    // Функциональный интерфейс (ровно один абстрактный метод)
    @FunctionalInterface
    interface Calculator {
        int calculate(int a, int b);
    }

    public static void main(String[] args) {
        Calculator add = (a, b) -> a + b;
        Calculator subtract = (a, b) -> a - b;
        Calculator multiply = (a, b) -> a * b;

        System.out.println("Сложение: " + add.calculate(5, 3));
        System.out.println("Вычитание: " + subtract.calculate(5, 3));
        System.out.println("Умножение: " + multiply.calculate(5, 3));
    }
}
~~~