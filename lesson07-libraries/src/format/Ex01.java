package format;

import java.text.NumberFormat;
import java.util.Locale;

public class Ex01 {
	public static void main(String[] args) {
		double digit = 1231235235345d;
		System.out.println("digit: "+digit);
		
		Locale locale = new Locale("da","DK");
		NumberFormat nf = NumberFormat.getInstance(locale);
		System.out.println("number instance: "+nf.format(digit));
		
		NumberFormat nfc = NumberFormat.getCurrencyInstance(locale);
		System.out.println("currency instance: "+nfc.format(digit));
	}
}
