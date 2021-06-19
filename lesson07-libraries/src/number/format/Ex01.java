package number.format;

import java.text.NumberFormat;
import java.util.Locale;

public class Ex01 {
	public static void main(String[] args) {
		double value = 12312457613221321d;
		
		
		Locale locale = Locale.US;
		
		NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
		System.out.println(nf.format(value));
	}

}
