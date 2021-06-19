package number.format;

import java.text.DecimalFormat;

public class Ex02 {
	private static final String PATTERN = "#,##0.00";
	public static void main(String[] args) {
		
		double number = 12345577.1545;
		DecimalFormat fm = new DecimalFormat(PATTERN);
		
		System.out.println("values: " + fm.format(number));
	}
}
