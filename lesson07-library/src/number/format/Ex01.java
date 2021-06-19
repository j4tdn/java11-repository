package number.format;

import java.text.NumberFormat;
import java.util.Locale;

public class Ex01 {
	public static void main(String[] args) {
		double value = 12345678912345678999d;
		System.out.println("value: " + value);
		
		//Locale locale = new Locale("da", "DK");
		Locale locale = Locale.US;
		
		NumberFormat nf = NumberFormat.getInstance();  //getInstance(truyen locale vao)
	//	NumberFormat nfg = NumberFormat.getCurrencyInstance(locale);  
		System.out.println("value: " + nf.format(value));
	}
}
