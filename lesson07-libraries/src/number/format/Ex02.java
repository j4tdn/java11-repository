package number.format;

import java.text.DecimalFormat;

public class Ex02 {
	private static final String PATTERN = "#,###.00";
	
	public static void main(String[] args) {
		double number = 123576824.123;
		DecimalFormat fm = new DecimalFormat(PATTERN);
		
		System.out.println("value: " + fm.format(number));
	}
}
