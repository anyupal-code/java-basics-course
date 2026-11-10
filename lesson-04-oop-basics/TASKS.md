# Задания к Уроку 4

## Задание 1. Класс «Студент»
Создайте класс `Student` со следующими полями:
* `name` (String) — имя студента.
* `age` (int) — возраст.
* `averageScore` (double) — средний балл.

Сделайте поля `private`. Напишите конструктор для инициализации всех полей, а также геттеры и сеттеры для каждого поля. 
В классе `MainOOP` создайте объект `Student` и выведите его данные в консоль.

**Решение:**
~~~java
package lesson04;

public class Student {
    private String name;
    private int age;
    private double averageScore;

    public Student(String name, int age, double averageScore) {
        this.name = name;
        this.age = age;
        this.averageScore = averageScore;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public double getAverageScore() { return averageScore; }
    public void setAverageScore(double averageScore) { this.averageScore = averageScore; }
}
~~~

---

## Задание 2. Валидация в сеттере
В классе `Student` из предыдущего задания добавьте проверку в сеттер `setAge()`: возраст не может быть меньше 0 или больше 120. Если передается некорректное значение, выводите сообщение об ошибке и оставляйте старое значение.

**Решение:**
~~~java
public void setAge(int age) {
    if (age >= 0 && age <= 120) {
        this.age = age;
    } else {
        System.out.println("Ошибка: некорректный возраст");
    }
}
~~~

---

## Задание 3. Переопределение toString()
Добавьте в класс `Student` переопределенный метод `toString()`, который возвращает строку в формате:
`Студент: [Имя], Возраст: [age], Средний балл: [averageScore]`.

В классе `MainOOP` создайте объект `Student` и выведите его через `System.out.println(student);`.

**Решение:**
~~~java
@Override
public String toString() {
    return "Студент: " + name + ", Возраст: " + age + ", Средний балл: " + averageScore;
}
~~~

---

## Задание 4 (*). Класс «Банковский счет»
Создайте класс `BankAccount` с полями:
* `owner` (String) — владелец счета.
* `balance` (double) — текущий баланс.

Сделайте баланс `private`. Напишите конструктор, который принимает владельца и начальный баланс (если баланс отрицательный, установите 0).
Добавьте методы:
* `deposit(double amount)` — пополнение счета (если сумма больше 0).
* `withdraw(double amount)` — снятие средств (если сумма больше 0 и не превышает баланс).
* `getBalance()` — возвращает текущий баланс.

**Решение:**
~~~java
package lesson04;

public class BankAccount {
    private String owner;
    private double balance;

    public BankAccount(String owner, double initialBalance) {
        this.owner = owner;
        if (initialBalance > 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Недостаточно средств или неверная сумма");
        }
    }

    public double getBalance() {
        return balance;
    }
}
~~~