import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.Locale;

public class BirthdayCalendar {

    public String collectBirthdays(int year, int month, int day) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy - E", Locale.ENGLISH);
        LocalDate date = LocalDate.now();
        LocalDate dateBirthday = LocalDate.of(year, month, day);

        StringBuilder builder = new StringBuilder();
        String birthdays = "";

        for (int i = 0; dateBirthday.compareTo(date) <= 0; i++) {
            birthdays = builder.append(i + " - " + dateBirthday.format(formatter) + "\n").toString();
            dateBirthday = dateBirthday.plusYears(1);
        }
        return birthdays;

    }
}
