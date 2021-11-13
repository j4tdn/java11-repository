package timezone;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.TimeZone;

import utils.DateUtils;

public class Ex01 {
	public static void main(String[] args) {
		//locale: language-country
		//time-zone GMT, UTC, Abrivation(HSK, ITC), Area
		
		TimeZone tzdef = TimeZone.getDefault();
		System.out.println("tzdef: "+tzdef);
		
		System.out.println("========================================");
		String[] avTzids = TimeZone.getAvailableIDs();
		for(String tzId: avTzids)
		{
			System.out.println(tzId);
		}
		TimeZone tzBerlin = TimeZone.getTimeZone("Etc/GMT-2");
		Calendar c =Calendar.getInstance(tzBerlin);
		System.out.println("datetime berlin: "+DateUtils.format(c));
		
		LocalDateTime dtBerlin = LocalDateTime.now(ZoneId.of("Europe/Berlin"));
		System.out.println("datetime berlin: "+dtBerlin);
	}
}
