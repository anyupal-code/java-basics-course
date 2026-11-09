package lesson02;

public class VariablesIntro {
    public static void main(String[] args) {
        int age = 25;
        double price = 10.99;
        boolean isStudent = true;
        char grade = 'A';
        String name = "Иван";

        System.out.println("Имя: " + name);
        System.out.println("Возраст: " + age);
        System.out.println("Цена: " + price);
        System.out.println("Студент: " + isStudent);
        System.out.println("Оценка: " + grade);

        // Константа
        final double PI = 3.14159;
        System.out.println("Пи: " + PI);
    }
}