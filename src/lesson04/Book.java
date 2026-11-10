package lesson04;

public class Book {
    private String title;
    private String author;
    private int year;

    // Конструктор
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    // Геттеры
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    // Сеттер с проверкой
    public void setYear(int year) {
        if (year > 0) {
            this.year = year;
        } else {
            System.out.println("Ошибка: год не может быть отрицательным");
        }
    }

    public void printInfo() {
        System.out.println(title + " (" + author + ", " + year + ")");
    }

    @Override
    public String toString() {
        return "Book{title='" + title + "', author='" + author + "', year=" + year + "}";
    }
}