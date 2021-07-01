package format;

import java.text.NumberFormat;
import java.util.Locale;

public class Ex01 {
	public static void main(String[] args) {
		double digit = 12312435764562389.2648d;
		System.out.println("digit: " + digit);
		
		Locale locale = new Locale("da", "DK");
		
		// NumberFormat: number
		NumberFormat nf = NumberFormat.getInstance(locale);
		System.out.println("instance: " + nf.format(digit));
		
		
		// NumberFormat: currency 
		NumberFormat nfc = NumberFormat.getCurrencyInstance(locale);
		System.out.println("currency instance: " + nfc.format(digit));
	}
}
