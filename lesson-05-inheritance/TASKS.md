# Задания к Уроку 5

## Задание 1. Иерархия «Транспорт»
Создайте абстрактный класс `Vehicle` с полем `speed` (int, protected) и абстрактным методом `move()`.
Создайте два дочерних класса:
* `Car` — в методе `move()` выводит "Машина едет со скоростью [speed] км/ч".
* `Bicycle` — в методе `move()` выводит "Велосипед едет со скоростью [speed] км/ч".

Создайте объекты обоих классов в `Main` и вызовите их методы `move()` через массив типа `Vehicle`.

**Решение:**

~~~java
package lesson05;

public abstract class Vehicle {
    protected int speed;

    public Vehicle(int speed) {
        this.speed = speed;
    }

    public abstract void move();
}
~~~

~~~java
package lesson05;

public class Car extends Vehicle {
    public Car(int speed) {
        super(speed);
    }

    @Override
    public void move() {
        System.out.println("Машина едет со скоростью " + speed + " км/ч");
    }
}
~~~

~~~java
package lesson05;

public class Bicycle extends Vehicle {
    public Bicycle(int speed) {
        super(speed);
    }

    @Override
    public void move() {
        System.out.println("Велосипед едет со скоростью " + speed + " км/ч");
    }
}
~~~

---

## Задание 2. Интерфейс «Летающий»
Создайте интерфейс `Flyable` с методом `fly()`.
Создайте класс `Airplane`, который наследует `Vehicle` и реализует `Flyable`. 
В методе `move()` самолет должен выводить "Самолет летит со скоростью [speed] км/ч", а в `fly()` — "Самолет набирает высоту".

Продемонстрируйте работу в `Main`, вызвав оба метода у объекта `Airplane`.

**Решение:**

~~~java
package lesson05;

public interface Flyable {
    void fly();
}
~~~

~~~java
package lesson05;

public class Airplane extends Vehicle implements Flyable {
    public Airplane(int speed) {
        super(speed);
    }

    @Override
    public void move() {
        System.out.println("Самолет летит со скоростью " + speed + " км/ч");
    }

    @Override
    public void fly() {
        System.out.println("Самолет набирает высоту");
    }
}
~~~

---

## Задание 3 (*). Переопределение метода
В задании 1 у класса `Vehicle` был метод `move()`. Добавьте в родительский класс обычный (не абстрактный) метод `stop()`, который выводит "Транспорт остановился".
Переопределите этот метод в классе `Car`, чтобы он выводил "Машина припаркована".
Вызовите `stop()` у объектов `Car` и `Bicycle`, чтобы увидеть разницу.

**Решение:**

~~~java
// В классе Vehicle:
public void stop() {
    System.out.println("Транспорт остановился");
}

// В классе Car:
@Override
public void stop() {
    System.out.println("Машина припаркована");
}
~~~