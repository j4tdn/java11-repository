package Exercise;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Ex01 {
	public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        ArrayList<String> list = new ArrayList<>();
        list = getAllDayInYear(2021, "SUNDAY");
        System.out.println("every Sunday of 2021");
        for (String string : list) {
            System.out.println(string);
        }
        System.out.println("1b: " + getLastSunDay(2021, "SUNDAY"));

    }

    private static ArrayList<String> getAllDayInYear(int year, String date) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        ArrayList<String> arr = new ArrayList<>();

        LocalDate dateStart = LocalDate.of(year, 1, 1);
        LocalDate dateEnd = LocalDate.of(year, 12, 31);

        while (!dateStart.isAfter(dateEnd)) {
            if (String.valueOf(dateStart.getDayOfWeek()).equals(date)) {
                arr.add(dtf.format(dateStart));
                dateStart = dateStart.plusDays(7);
            } else {
                dateStart = dateStart.plusDays(1);
            }
        }

        return arr;
    }

    private static String getLastSunDay(int year, String date) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        int count = 7;

        LocalDate dateEnd = LocalDate.of(year, 12, 31);

        while (count >= 0) {
            if (String.valueOf(dateEnd.getDayOfWeek()).equals(date)) {
                return dtf.format(dateEnd);
            } else {
                dateEnd = dateEnd.plusDays(-1);
                count--;
            }
        }
        return dtf.format(dateEnd);
    }

}
