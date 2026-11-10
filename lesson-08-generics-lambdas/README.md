# Урок 8. Generics, лямбда-выражения и Optional

## Цель урока
Понять, как работают обобщения (Generics) для безопасной работы с типами, освоить лямбда-выражения для сокращения кода и научиться избегать `NullPointerException` с помощью `Optional`.

---

## Теория

### 1. Generics (Обобщения)
Generics позволяют создавать классы и методы, которые работают с разными типами данных, при этом обеспечивая проверку типов на этапе компиляции.
Вы уже сталкивались с ними, когда писали `List<String>` или `Map<String, Integer>`.

~~~java
// Без Generics (плохо)
List list = new ArrayList();
list.add("Строка");
list.add(123); // Компилятор пропустит, но потом будет ошибка при извлечении

// С Generics (хорошо)
List<String> safeList = new ArrayList<>();
safeList.add("Строка");
// safeList.add(123); // Ошибка компиляции - мы сказали, что тут только String
~~~

Можно создавать свои обобщенные классы:

~~~java
public class Box<T> {
    private T item;

    public void put(T item) {
        this.item = item;
    }

    public T get() {
        return item;
    }
}
~~~

`T` — это параметр типа (может быть любым, например `String`, `Integer`, `Book`).

### 2. Лямбда-выражения
Лямбда-выражение — это короткий способ записать анонимную функцию (функцию без имени).
Они используются, когда нужно передать поведение (действие) в метод.

Синтаксис:
`(параметры) -> { тело }`

Пример с интерфейсом `Runnable` (без лямбды):
~~~java
Runnable r = new Runnable() {
    @Override
    public void run() {
        System.out.println("Привет!");
    }
};
~~~

С лямбдой:
~~~java
Runnable r = () -> System.out.println("Привет!");
~~~

Лямбды часто используются вместе с коллекциями (например, в `forEach`):
~~~java
List<String> names = List.of("Иван", "Мария", "Петр");
names.forEach(name -> System.out.println(name));
~~~

### 3. Функциональные интерфейсы
Лямбда-выражения работают только с **функциональными интерфейсами** — интерфейсами, в которых ровно один абстрактный метод.
В Java есть готовые функциональные интерфейсы в пакете `java.util.function`:
* `Consumer<T>` — принимает объект, ничего не возвращает (`void accept(T t)`).
* `Function<T, R>` — принимает объект типа `T`, возвращает объект типа `R` (`R apply(T t)`).
* `Predicate<T>` — принимает объект, возвращает `boolean` (`boolean test(T t)`).

### 4. Optional
`Optional<T>` — это контейнер, который может содержать значение, а может быть пустым.
Он создан, чтобы явно показать: «этот метод может ничего не вернуть», и избежать `NullPointerException`.

Создание:
~~~java
Optional<String> optionalName = Optional.of("Иван"); // Значение есть
Optional<String> empty = Optional.empty(); // Значение отсутствует
Optional<String> nullable = Optional.ofNullable(null); // Может быть null
~~~

Использование:
~~~java
Optional<String> name = Optional.ofNullable(getNameFromDatabase());

// Если значение есть, вывести его. Если нет - вывести "Не найдено"
name.ifPresentOrElse(
    n -> System.out.println("Имя: " + n),
    () -> System.out.println("Не найдено")
);

// Либо вернуть значение по умолчанию, если пусто
String result = name.orElse("Неизвестно");
~~~

---

## Практика
Примеры кода для запуска лежат в папке `src/lesson08/`:
* `GenericsExample.java` — создание обобщенного класса.
* `LambdaExample.java` — работа с лямбда-выражениями.
* `OptionalExample.java` — безопасная работа с возможным `null`.

Переходите к [Заданиям](TASKS.md) для самостоятельной работы.

---

## Чек-лист
- [ ] Понимаю, зачем нужны Generics.
- [ ] Умею создавать обобщенные классы (`<T>`).
- [ ] Понимаю синтаксис лямбда-выражений.
- [ ] Знаю, что такое функциональный интерфейс.
- [ ] Умею использовать `Optional` для избежания `NullPointerException`.

---

## Что дальше
На следующем уроке разберём **Stream API**.