package number.format;

import java.text.NumberFormat;
import java.util.Locale;

public class Ex01 {
	public static void main(String[] args) {
		double value = 1231243574562389d;

		System.out.println("value: " + value);

		Locale locale = Locale.FRANCE;

		NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
		System.out.println("value format: " + nf.format(value));

	}

}
