package number.format;

import java.text.NumberFormat;
import java.util.Locale;

public class Ex01 {
	public static void main(String[] args) {
		double value = 1234567892343243d;
		
		Locale locale = new Locale("vi", "VN");
		
		NumberFormat nf = NumberFormat.getInstance(locale);
		System.out.println("value: " + nf.format(value));
	}
}
