package lesson10;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DateTimeExample {
    public static void main(String[] args) {
        // 1. Текущая дата и время
        LocalDate today = LocalDate.now();
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Сегодня: " + today);
        System.out.println("Сейчас: " + now);

        // 2. Конкретная дата
        LocalDate specificDate = LocalDate.of(2026, Month.NOVEMBER, 11);
        System.out.println("Заданная дата: " + specificDate);

        // 3. Арифметика дат
        LocalDate nextWeek = today.plusWeeks(1);
        LocalDate yesterday = today.minusDays(1);
        System.out.println("Через неделю: " + nextWeek);
        System.out.println("Вчера: " + yesterday);

        // 4. Разница между датами
        LocalDate start = LocalDate.of(2026, 1, 1);
        LocalDate end = LocalDate.of(2026, 12, 31);
        Period period = Period.between(start, end);
        System.out.println("Разница между 1 января и 31 декабря: " 
            + period.getMonths() + " мес. и " + period.getDays() + " дн.");

        // 5. Форматирование
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        System.out.println("Отформатированная дата: " + specificDate.format(formatter));
    }
}