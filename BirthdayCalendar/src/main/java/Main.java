import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        int day = 12;
        int month = 12;
        int year = 2005;

        System.out.println(collectBirthdays(year, month, day));
    }

    public static String collectBirthdays(int year, int month, int day) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy - E", Locale.ENGLISH);
        LocalDate date = LocalDate.now();
        LocalDate dateBirthday = LocalDate.of(year, month, day);

        StringBuilder builder = new StringBuilder();
        String str = "";

        for (int i = 0; dateBirthday.compareTo(date) <= 0; i++) {
            str = builder.append(i + " - " + dateBirthday.format(formatter) + "\n").toString();
            dateBirthday = dateBirthday.plusYears(1);
        }
        return str;

    }
}
