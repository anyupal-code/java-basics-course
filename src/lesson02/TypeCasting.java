package lesson02;

public class TypeCasting {
    public static void main(String[] args) {
        // Автоматическое (расширяющее) преобразование
        int a = 10;
        double b = a;
        System.out.println("Автоматическое: int " + a + " -> double " + b);

        // Явное (сужение) преобразование
        double d = 10.99;
        int i = (int) d;
        System.out.println("Явное: double " + d + " -> int " + i + " (дробная часть отбрасывается)");

        // Потеря данных при сужении
        int bigInt = 130;
        byte smallByte = (byte) bigInt;
        System.out.println("Потеря данных: int 130 -> byte " + smallByte);
    }
}