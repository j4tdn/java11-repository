package timezone;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.TimeZone;

import utils.DateUtils;

public class Ex01 {
	public static void main(String[] args) {
		// locale: language - country
		// time-zone: GMT, UTC, Abbreviation(HSK, ITC), Area
		
		// system
		TimeZone tzdef = TimeZone.getDefault();
		System.out.println(tzdef);
			
		System.out.println("=================================");
		String[] avTzids = TimeZone.getAvailableIDs();
		for(String tzId : avTzids) {
			System.out.println(tzId);
		}
		
		// Europe Berlin = Etc/GMT-2
		TimeZone tzBerlin = TimeZone.getTimeZone("Europe/Berlin");
		Calendar c = Calendar.getInstance(tzBerlin);
		System.out.println("datetime Berlin: " + DateUtils.format(c,tzBerlin));
	
		LocalDateTime dtBerlin = LocalDateTime.now(ZoneId.of("Europe/Berlin"));
		System.out.println("datetime Berlin: " + dtBerlin);
	}
}
