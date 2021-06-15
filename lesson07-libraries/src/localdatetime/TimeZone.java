package localdatetime;

import java.time.LocalDateTime;
import java.time.ZoneId;
public class TimeZone {
	public static void main(String[] args) {
   // Locale -> country, language  >>>> FirstDayOfWeek
   // Locale VN -> vi, VN
   // Locale USA -> en, us
	
   // TimeZone
   // GMT, UTC, ICT
	String zoneId = "Europe/Berlin";
	zoneId = "Etc/GMT -2";
	LocalDateTime datetime = LocalDateTime.now(ZoneId.of("Europe/Berlin"));
    System.out.println("datetime: " + datetime);
    String[] zoneIds = java.util.TimeZone.getAvailableIDs();
    for(String zone: zoneIds) {
    	System.out.println(zone);
      }
	}
}
