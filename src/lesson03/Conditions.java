package lesson03;

public class Conditions {
    public static void main(String[] args) {
        int age = 18;

        if (age >= 18) {
            System.out.println("Доступ разрешен");
        } else {
            System.out.println("Доступ запрещен");
        }

        int score = 85;
        if (score >= 90) {
            System.out.println("Отлично");
        } else if (score >= 70) {
            System.out.println("Хорошо");
        } else {
            System.out.println("Нужно подтянуть");
        }

        boolean isWeekend = true;
        boolean isHoliday = false;

        if (isWeekend || isHoliday) {
            System.out.println("Отдыхаем!");
        }
    }
}