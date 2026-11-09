# Задания к Уроку 2

## Задание 1. Обмен значений
Объявите две целочисленные переменные `a = 5` и `b = 10`. Поменяйте их значения местами так, чтобы `a` стало `10`, а `b` стало `5`. Выведите результат в консоль.

Ожидаемый вывод:
    a = 10, b = 5

**Решение:**
~~~java
package lesson02;

public class Task1 {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;
        
        int temp = a;
        a = b;
        b = temp;
        
        System.out.println("a = " + a + ", b = " + b);
    }
}
~~~
---

## Задание 2. Площадь и периметр
Пользователь вводит с клавиатуры длину и ширину прямоугольника (целые числа). Вычислите и выведите его площадь (`длина * ширина`) и периметр (`2 * (длина + ширина)`).

**Решение:**
~~~java
package lesson02;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите длину: ");
        int length = scanner.nextInt();
        
        System.out.print("Введите ширину: ");
        int width = scanner.nextInt();
        
        int area = length * width;
        int perimeter = 2 * (length + width);
        
        System.out.println("Площадь: " + area);
        System.out.println("Периметр: " + perimeter);
        
        scanner.close();
    }
}
~~~
---

## Задание 3. Среднее арифметическое
Пользователь вводит три дробных числа (`double`). Найдите и выведите их среднее арифметическое.

**Решение:**
~~~java
package lesson02;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите первое число: ");
        double a = scanner.nextDouble();
        
        System.out.print("Введите второе число: ");
        double b = scanner.nextDouble();
        
        System.out.print("Введите третье число: ");
        double c = scanner.nextDouble();
        
        double average = (a + b + c) / 3.0;
        
        System.out.println("Среднее арифметическое: " + average);
        
        scanner.close();
    }
}
~~~
---

## Задание 4 (*). Калькулятор скидки
Пользователь вводит стоимость товара (`double`) и процент скидки (`int`). Вычислите итоговую стоимость с учетом скидки. 
*Подсказка:* скидка вычисляется как `(стоимость * процент) / 100.0`.

**Решение:**
~~~java
package lesson02;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите стоимость товара: ");
        double price = scanner.nextDouble();
        
        System.out.print("Введите процент скидки: ");
        int discount = scanner.nextInt();
        
        double discountAmount = (price * discount) / 100.0;
        double finalPrice = price - discountAmount;
        
        System.out.println("Скидка: " + discountAmount);
        System.out.println("Итоговая цена: " + finalPrice);
        
        scanner.close();
    }
}
~~~