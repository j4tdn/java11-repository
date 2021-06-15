package utils;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class TimeZone {
	public static void main(String[] args) {
		
		String zoneId = "EU/Berlin";
		zoneId = "ETC/GMT-2";
		
		LocalDateTime dateTime = LocalDateTime.now(ZoneId.of(""));
		System.out.println("datetime: " + dateTime);
		
		System.out.println("=================================");
		String[] zoneIds = java.util.TimeZone.getAvailableIDs();
		for(String zone:zoneIds) {
			System.out.println(zone);
		}
	}
}
