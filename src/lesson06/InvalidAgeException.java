package lesson06;

// Наследуемся от Exception (checked исключение)
//Свое исключение
public class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message); // Передаем сообщение в родительский класс
    }
}