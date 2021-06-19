package number.format;

import java.text.NumberFormat;
import java.util.Locale;

public class Ex01 {
	public static void main(String[] args) {
		double value = 12312435764562389d;
//		Locale denmark = Locale.US;
		Locale locale = new Locale("vi", "VN");
		// NumberFormat nf = NumberFormat.getInstance(locale);
		 NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
		
		System.out.println("value: " + value);
		System.out.println("value: " + nf.format(value));
	}
}
