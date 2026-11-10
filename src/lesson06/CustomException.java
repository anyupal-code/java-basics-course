package lesson06;
//Демонстрация работы своего исключения
public class CustomException {
    
    // В сигнатуре метода указываем, что он может выбросить InvalidAgeException
    public static void checkAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 120) {
            // Явно выбрасываем наше исключение
            throw new InvalidAgeException("Некорректный возраст: " + age);
        }
        System.out.println("Возраст корректен: " + age);
    }

    public static void main(String[] args) {
        try {
            checkAge(25);   // Отработает без ошибок
            checkAge(150);  // Выбросит исключение, управление перейдет в catch
        } catch (InvalidAgeException e) {
            // Перехватываем наше исключение и выводим сообщение
            System.out.println("Перехвачено исключение: " + e.getMessage());
        }
        
        System.out.println("Программа продолжает работу.");
    }
}