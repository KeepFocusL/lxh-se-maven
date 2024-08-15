package day240812.app_with_db.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyDateUtil {
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static void setDateTimeFormatter(DateTimeFormatter dateTimeFormatter) {
        MyDateUtil.dateTimeFormatter = dateTimeFormatter;
    }

    public static String localDateTimeToString(LocalDateTime localDateTime) {
        return dateTimeFormatter.format(localDateTime);
    }

    public static LocalDateTime stringToLocalDateTime(String dateStr) {
        return LocalDateTime.parse(dateStr, dateTimeFormatter);
    }

    public static boolean isAfterOrEquals(LocalDateTime localDateTime1, LocalDateTime localDateTime2) {
        //return localDateTime2.compareTo(localDateTime1) >= 0;
        return !localDateTime2.isBefore(localDateTime1);
    }

    public static void main(String[] args) {
        LocalDateTime localDateTime = MyDateUtil.stringToLocalDateTime("2024-06-05 09:10");
        System.out.println(localDateTime);

        String string = MyDateUtil.localDateTimeToString(LocalDateTime.now());
        System.out.println(string);

        LocalDateTime localDateTime1 = MyDateUtil.stringToLocalDateTime("2024-06-05 09:10");
        LocalDateTime localDateTime2 = MyDateUtil.stringToLocalDateTime("2024-06-05 09:00");
        System.out.println(MyDateUtil.isAfterOrEquals(localDateTime1, localDateTime2));
    }
}
