package lesson10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReadWrite {
    public static void main(String[] args) {
        // 1. Определяем путь к файлу в текущей папке
        Path filePath = Paths.get("example.txt");

        // 2. Запись данных в файл
        List<String> linesToWrite = List.of(
            "Первая строка",
            "Вторая строка",
            "Третья строка"
        );

        try {
            Files.write(filePath, linesToWrite);
            System.out.println("Файл успешно записан по пути: " + filePath.toAbsolutePath());
        } catch (IOException e) {
            System.out.println("Ошибка при записи файла: " + e.getMessage());
        }

        // 3. Чтение данных из файла
        try {
            System.out.println("\n--- Содержимое файла ---");
            List<String> readLines = Files.readAllLines(filePath);
            for (String line : readLines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }

        // 4. Проверка существования файла
        if (Files.exists(filePath)) {
            System.out.println("\nФайл существует.");
        }
    }
}