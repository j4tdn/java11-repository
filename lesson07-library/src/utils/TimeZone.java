package utils;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class TimeZone {
	public static void main(String[] args) {
		//Locale ->language, country >>> FirstDayOfWeek
		//Locale  VN -> vi ,VN
		// Locale US -> en, US
		
		
		//TimeZone
		// GTM, UTC
		//ICT
		
		String zoneId = "Europe/Berlin";
		zoneId = "Etc/GMT-2";
		
		LocalDateTime datetime = LocalDateTime.now(ZoneId.of(zoneId));
		System.out.println("datetime: " + datetime);
		
		System.out.println("========================================");
		
		String[] zoneIds = java.util.TimeZone.getAvailableIDs();
		for (String zone : zoneIds) {
	//		System.out.println(zone);
		}
	}
}
