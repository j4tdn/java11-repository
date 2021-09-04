package utils;

import java.util.Arrays;
import java.util.List;

import bean.Trader;

public class TraderUtils {

	public TraderUtils() {

	}

	public static List<Trader> getTraderAll() {
		return Arrays.asList(
				new Trader("Raoul", "Cambridge"),
				new Trader("Mario", "Milan"),
				new Trader("Alan", "Cambridge"),
				new Trader("Brian", "Cambridge")
				);
	}
}
