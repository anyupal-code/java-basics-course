# Задания к Уроку 1

## Задание 1. Визитная карточка
Напишите программу, которая выводит в консоль:
1. Ваше имя.
2. Вашу цель (например: "Хочу стать Java-разработчиком").
3. Текущий год.
4. Пустую строку в конце.

Ожидаемый вывод:

    Иван
    Хочу стать Java-разработчиком
    2026

**Решение:**
~~~java
package lesson01;

public class Task1 {
    public static void main(String[] args) {
        System.out.println("Иван");
        System.out.println("Хочу стать Java-разработчиком");
        System.out.println("2026");
        System.out.println(); // Пустая строка
    }
}
~~~
---

## Задание 2. Таблица с выравниванием
Используя спецсимвол табуляции `\t`, выведите расписание на неделю в виде двух колонок: день недели и предмет (или задача). 
Первая строка должна быть заголовком.

Ожидаемый вывод (пример):

    День	Задача
    Пн	    Java
    Вт	    Java
    Ср	    Java

**Решение:**
~~~java
    package lesson01;

    public class Task2 {
        public static void main(String[] args) {
            System.out.println("День\tЗадача");
            System.out.println("Пн\tJava");
            System.out.println("Вт\tJava");
            System.out.println("Ср\tJava");
        }
    }
~~~
---

## Задание 3. Рамка из символов
Выведите слово "Java" внутри рамки из символов `*`. Рамка должна быть ровной, без смещений.

Ожидаемый вывод:

    ******
    *    *
    *Java*
    *    *
    ******

**Решение:**
~~~java
    package lesson01;

    public class Task3 {
        public static void main(String[] args) {
            System.out.println("******");
            System.out.println("*    *");
            System.out.println("*Java*");
            System.out.println("*    *");
            System.out.println("******");
        }
    }
~~~
---

## Задание 4 (*). Кавычки и слэши
Выведите на экран следующую строку (обратите внимание на кавычки и обратный слэш внутри):

    Он сказал: "Я учу Java" и добавил: C:\Java\bin

Подсказка: используйте экранирование `\"` и `\\`.

**Решение:**
~~~java
    package lesson01;

    public class Task4 {
        public static void main(String[] args) {
            System.out.println("Он сказал: \"Я учу Java\" и добавил: C:\\Java\\bin");
        }
    }
~~~