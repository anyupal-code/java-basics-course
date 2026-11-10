package lesson05;
//Наследник
public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " мяукает.");
    }

    @Override
    public void eat() {
        System.out.println(name + " ест рыбу.");
    }
}