package number.format;

import java.text.DecimalFormat;

public class Ex02 {
	private static final String PATTERN = "#,###.00000";
	public static void main(String[] args) {
		double number = 498441.2216;
		DecimalFormat fm = new DecimalFormat(PATTERN);
		
		System.out.println("value: " + fm.format(number));
	}
}
