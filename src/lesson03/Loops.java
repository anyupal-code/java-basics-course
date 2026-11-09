package lesson03;

public class Loops {
    public static void main(String[] args) {
        System.out.println("--- Цикл for ---");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Итерация: " + i);
        }

        System.out.println("\n--- Цикл while ---");
        int j = 1;
        while (j <= 5) {
            System.out.println("Итерация: " + j);
            j++;
        }

        System.out.println("\n--- Цикл do-while ---");
        int k = 10;
        do {
            System.out.println("Это выполнится один раз, даже если k=10");
            k++;
        } while (k < 5);
    }
}