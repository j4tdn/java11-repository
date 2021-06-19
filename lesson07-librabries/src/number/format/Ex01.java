package number.format;

import java.text.NumberFormat;
import java.util.Locale;

public class Ex01 {
	public static void main(String[] args) {
		double value = 123123111111111111111d;
		System.out.println("value: " + value);
		
		Locale us = Locale.US;
		Locale vn =  new Locale("vi","VN" );
		
		NumberFormat numberFormat = NumberFormat.getInstance();
		NumberFormat nf = NumberFormat.getCurrencyInstance(vn);
		
		System.out.println(" value: " + numberFormat.format(value));
		System.out.println(" value: " + nf.format(value));
	}
}
