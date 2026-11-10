package lesson08;

public class GenericsExample {
    // Обобщенный класс
    static class Box<T> {
        private T item;

        public void put(T item) {
            this.item = item;
        }

        public T get() {
            return item;
        }
    }

    public static void main(String[] args) {
        // Коробка для строк
        Box<String> stringBox = new Box<>();
        stringBox.put("Привет");
        System.out.println("Строка: " + stringBox.get());

        // Коробка для чисел
        Box<Integer> intBox = new Box<>();
        intBox.put(42);
        System.out.println("Число: " + intBox.get());
    }
}