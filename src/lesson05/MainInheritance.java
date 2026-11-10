package lesson05;
//Точка входа для демонстрации
public class MainInheritance {
    public static void main(String[] args) {
        Dog dog = new Dog("Шарик");
        Cat cat = new Cat("Мурка");
        Duck duck = new Duck("Кряква");

        System.out.println("--- Полиморфизм (вызов через родительский тип) ---");
        Animal[] animals = {dog, cat, duck};
        for (Animal animal : animals) {
            animal.makeSound(); // У каждого свой звук
        }

        System.out.println("\n--- Переопределение методов ---");
        dog.eat(); 
        cat.eat(); // У кошки своя реализация

        System.out.println("\n--- Работа с интерфейсом ---");
        duck.swim();
    }
}