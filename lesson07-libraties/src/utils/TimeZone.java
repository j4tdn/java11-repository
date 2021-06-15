package utils;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class TimeZone {
	public static void main(String[] args) {
		// Locale -> language, country
		// Locale VN 	-> vi, VN
		// Locale USA 	-> en, US
		
		// TimeZone
		// GMT, UTC
		// ICT
		
		String zoneId = "Europ/Berlin";
		zoneId = "Etc/GMT-2";
		
		LocalDateTime datetime = LocalDateTime.now(ZoneId.of(zoneId));
		System.out.println("datetime: " + datetime);
		
		String[] zones = java.util.TimeZone.getAvailableIDs();
		for (String zone: zones) {
			System.out.println(zone);
		}
	}
}
