# Урок 7. Коллекции: List, Set, Map

## Цель урока
Научиться хранить и обрабатывать наборы данных с помощью динамических коллекций, понять разницу между List, Set и Map, а также освоить методы equals() и hashCode().

---

## Теория

### 1. Зачем нужны коллекции?
Массивы имеют фиксированный размер: если вы создали массив на 5 элементов, вы не можете добавить шестой. 
Коллекции — это динамические структуры данных, которые могут расти и уменьшаться по мере необходимости.
Все коллекции находятся в пакете `java.util`.

### 2. List (Список)
Список — это упорядоченная коллекция, которая **позволяет дубликаты** элементов. Доступ к элементам осуществляется по индексу (как в массиве).
Основные реализации:
* `ArrayList` — быстрый доступ по индексу, но медленное добавление/удаление в середину (на практике используется чаще всего).
* `LinkedList` — быстрое добавление/удаление, но медленный доступ по индексу.

~~~java
import java.util.ArrayList;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Иван");
        names.add("Мария");
        names.add("Иван"); // Дубликат разрешен

        System.out.println(names.get(0)); // Иван
        System.out.println(names.size()); // 3
        System.out.println(names.contains("Мария")); // true
    }
}
~~~

### 3. Set (Множество)
Множество — это коллекция, которая **не содержит дубликатов**. Порядок элементов не гарантируется.
Основные реализации:
* `HashSet` — самый быстрый, но порядок элементов непредсказуем.
* `TreeSet` — хранит элементы в отсортированном порядке (по алфавиту или возрастанию).

~~~java
import java.util.HashSet;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        Set<String> uniqueNames = new HashSet<>();
        uniqueNames.add("Иван");
        uniqueNames.add("Мария");
        uniqueNames.add("Иван"); // Дубликат не добавится

        System.out.println(uniqueNames.size()); // 2
    }
}
~~~

### 4. Map (Словарь / Карта)
`Map` хранит данные в виде пар «ключ — значение». 
Ключи **уникальны**, значения могут повторяться.
Основные реализации:
* `HashMap` — самая популярная, порядок не гарантируется.
* `TreeMap` — сортирует элементы по ключу.

~~~java
import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        Map<String, Integer> ages = new HashMap<>();
        ages.put("Иван", 25);
        ages.put("Мария", 30);
        ages.put("Иван", 26); // Значение для ключа "Иван" перезапишется

        System.out.println(ages.get("Иван")); // 26
        System.out.println(ages.containsKey("Мария")); // true
        System.out.println(ages.keySet()); // [Иван, Мария]
    }
}
~~~

### 5. Методы equals() и hashCode()
Для правильной работы `HashSet` и `HashMap` классы, которые вы в них добавляете, должны корректно переопределять методы `equals()` и `hashCode()`.
* `equals()` — проверяет логическое равенство двух объектов.
* `hashCode()` — возвращает целое число (хэш), которое используется для быстрого поиска в хэш-таблицах.

Если вы переопределяете `equals()`, вы **обязаны** переопределить и `hashCode()`, чтобы объекты, которые считаются равными, имели одинаковый хэш.

~~~java
public class Book {
    private String title;

    // ... конструктор и геттеры ...

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
~~~

*Примечание: в IDEA эти методы можно сгенерировать автоматически: `Alt+Insert` -> `equals() and hashCode()`.*

---

## Практика
Примеры кода для запуска лежат в папке `src/lesson07/`:
* `ListExample.java` — работа со списком.
* `SetExample.java` — работа с множеством.
* `MapExample.java` — работа со словарем.

Переходите к [Заданиям](TASKS.md) для самостоятельной работы.

---

## Чек-лист
- [ ] Понимаю, зачем нужны коллекции вместо массивов.
- [ ] Знаю разницу между List, Set и Map.
- [ ] Умею использовать `add`, `get`, `put`, `size`.
- [ ] Понимаю, зачем нужны `equals()` и `hashCode()`.

---

## Что дальше
На следующем уроке разберём **Generics, лямбда-выражения и Optional**.