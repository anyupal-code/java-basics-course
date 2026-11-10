package lesson05;
//Класс, который наследует и реализует интерфейс
public class Duck extends Animal implements Swimmable {
    public Duck(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " крякает.");
    }

    @Override
    public void swim() {
        System.out.println(name + " плывет.");
    }
}