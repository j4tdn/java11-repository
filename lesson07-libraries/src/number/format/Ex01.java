package number.format;

import java.text.NumberFormat;
import java.util.Locale;

public class Ex01 {
	public static void main(String[] args) {
		double value = 123124351121123d;
		System.out.println("value: " + value);
		
		Locale locale = Locale.US;
		Locale denmark = new Locale("da", "DK");
		Locale vn = new Locale("vi", "VN");
		
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		System.out.println("value: " + nf.format(value));
	}
}
