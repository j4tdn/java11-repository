package Exercise;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;

public class Ex02 {
	 public static void main(String[] args) {
	        LocalDateTime dtStart;
	        LocalDateTime dtEnd;

	        String s, st;
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	        Scanner ip = new Scanner(System.in);

	        System.out.println("  when did you start falling in love? ");
	        s = ip.nextLine() + " 00:00:00";
	        dtStart = LocalDateTime.parse(s, formatter);

	        System.out.println("Is your love still?  (yes/no)");
	        st = ip.nextLine();
	        DayOfWeek dayofweek = dtStart.getDayOfWeek();

	        if (st.equals("no")) {
	            System.out.println("i'm SORRY!!  BUT YOU CAN ENTER DATE OF PARTICIPATION: ");
	            s = ip.nextLine() + " 00:00:00";
	            dtEnd = LocalDateTime.parse(s, formatter);
	            
	            System.out.println("weekdays first met: " + dayofweek);
	            System.out.println(between(dtStart, dtEnd));
	        } else {
	            System.out.println("weekdays first met: " + dayofweek);
	            System.out.println(between(dtStart, LocalDateTime.now()));
	        }

	    }

	    private static String between(LocalDateTime dtStart, LocalDateTime dtEnd) {
	        Objects.requireNonNull(dtStart);
	        Objects.requireNonNull(dtEnd);

	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	        if (dtStart.isAfter(dtEnd)) {
	            throw new IllegalArgumentException("StartDate cannot exceed EndDate !!!");
	        }

	        LocalDate dateStart = dtStart.toLocalDate();
	        LocalDate dateEnd = dtEnd.toLocalDate();

	        LocalTime timeStart = dtStart.toLocalTime();
	        LocalTime timeEnd = dtEnd.toLocalTime();

	        Period period = Period.between(dateStart, dateEnd);
	        Duration duration = Duration.between(timeStart, timeEnd);

	        if (timeEnd.isBefore(timeStart)) {
	            duration = duration.plusDays(1);
	            period = period.minusDays(1);
	        }

	        return period.toString() + " - " + duration.toString();

	    }
}
