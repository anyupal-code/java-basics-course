package lesson04;

public class MainOOP {
    public static void main(String[] args) {
        // Создание объекта через конструктор
        Book book1 = new Book("Война и мир", "Лев Толстой", 1869);
        
        // Использование метода printInfo()
        book1.printInfo();

        // Использование геттера
        System.out.println("Название книги: " + book1.getTitle());

        // Использование сеттера (успешно)
        book1.setYear(1873);
        System.out.println("Год после изменения: " + book1.getYear());

        // Использование сеттера (с ошибкой)
        book1.setYear(-5);

        // Вывод объекта через toString()
        System.out.println(book1);
    }
}