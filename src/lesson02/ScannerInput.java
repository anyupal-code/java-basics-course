package lesson02;

import java.util.Scanner;

public class ScannerInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ваше имя: ");
        String name = scanner.nextLine();

        System.out.print("Введите ваш возраст: ");
        int age = scanner.nextInt();

        System.out.println("Привет, " + name + "! Твой возраст: " + age);

        scanner.close();
    }
}