package number.format;

import java.text.NumberFormat;
import java.util.Locale;

public class Ex01 {
	public static void main(String[] args) {
		double value = 12312435767854675d;
		System.out.println("value: " + value);
		
		Locale locale = new Locale("vi", "VN");
//		Locale locale = Locale.FRANCE;
		
//		NumberFormat nf = NumberFormat.getInstance(locale);
		NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
		System.out.println("value: " + nf.format(value));
	}
}