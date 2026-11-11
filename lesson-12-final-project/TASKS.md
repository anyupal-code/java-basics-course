# Итоговый проект. Пошаговая инструкция

Создайте файлы в папке `src/lesson12/` в соответствии с этой инструкцией.

## Шаг 1. Модель данных (`Book.java`)

~~~java
package lesson12;

import java.time.LocalDate;

public class Book {
    private int id;
    private String title;
    private String author;
    private boolean isAvailable;
    private LocalDate issueDate;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = true; // По умолчанию доступна
    }

    // Геттеры и сеттеры
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return isAvailable; }
    public LocalDate getIssueDate() { return issueDate; }

    public void setAvailable(boolean available) { 
        this.isAvailable = available; 
        if (!available) {
            this.issueDate = LocalDate.now();
        } else {
            this.issueDate = null;
        }
    }

    @Override
    public String toString() {
        String status = isAvailable ? "Доступна" : "Выдана " + issueDate;
        return "[" + id + "] " + title + " - " + author + " (" + status + ")";
    }
}
~~~

## Шаг 2. Свое исключение (`BookNotAvailableException.java`)

~~~java
package lesson12;

public class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String message) {
        super(message);
    }
}
~~~

## Шаг 3. Сервис (бизнес-логика) (`LibraryService.java`)

~~~java
package lesson12;

import java.util.HashMap;
import java.util.Map;

public class LibraryService {
    private Map<Integer, Book> books = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    public void printAllBooks() {
        if (books.isEmpty()) {
            System.out.println("Библиотека пуста.");
            return;
        }
        books.values().forEach(System.out::println);
    }

    public void issueBook(int id) throws BookNotAvailableException {
        Book book = books.get(id);
        if (book == null) {
            throw new BookNotAvailableException("Книга с ID " + id + " не найдена.");
        }
        if (!book.isAvailable()) {
            throw new BookNotAvailableException("Книга '" + book.getTitle() + "' уже выдана.");
        }
        book.setAvailable(false);
        System.out.println("Книга '" + book.getTitle() + "' успешно выдана.");
    }

    public void returnBook(int id) throws BookNotAvailableException {
        Book book = books.get(id);
        if (book == null) {
            throw new BookNotAvailableException("Книга с ID " + id + " не найдена.");
        }
        if (book.isAvailable()) {
            throw new BookNotAvailableException("Книга '" + book.getTitle() + "' и так доступна.");
        }
        book.setAvailable(true);
        System.out.println("Книга '" + book.getTitle() + "' возвращена.");
    }
}
~~~

## Шаг 4. Точка входа и меню (`Main.java`)

~~~java
package lesson12;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryService library = new LibraryService();
        Scanner scanner = new Scanner(System.in);

        // Добавим пару книг для теста
        library.addBook(new Book(1, "Война и мир", "Лев Толстой"));
        library.addBook(new Book(2, "1984", "Джордж Оруэлл"));
        library.addBook(new Book(3, "Мастер и Маргарита", "Михаил Булгаков"));

        while (true) {
            System.out.println("\n--- Меню библиотеки ---");
            System.out.println("1. Показать все книги");
            System.out.println("2. Выдать книгу");
            System.out.println("3. Вернуть книгу");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");

            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1":
                        library.printAllBooks();
                        break;
                    case "2":
                        System.out.print("Введите ID книги: ");
                        int issueId = Integer.parseInt(scanner.nextLine());
                        library.issueBook(issueId);
                        break;
                    case "3":
                        System.out.print("Введите ID книги: ");
                        int returnId = Integer.parseInt(scanner.nextLine());
                        library.returnBook(returnId);
                        break;
                    case "0":
                        System.out.println("Выход из программы.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Неверный пункт меню.");
                }
            } catch (BookNotAvailableException e) {
                System.out.println("Ошибка: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: ID должен быть числом.");
            }
        }
    }
}
~~~