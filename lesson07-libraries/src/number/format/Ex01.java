package number.format;

import java.text.NumberFormat;
import java.util.Locale;

public class Ex01 {
	public static void main(String[] args) {
		double value = 1231242376455d;
		Locale locale = new Locale("vi", "vn");
		
		NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
		System.out.println("value: " + nf.format(value));

	}
}
