package number.format;

import java.text.DecimalFormat;

public class Ex02 {
	private static final String PATTERN = "#,###.00";
	
	public static void main(String[] args) {
		double number = 12345678.2345;
		DecimalFormat format = new DecimalFormat(PATTERN);
		
		System.out.println("value : " + format.format(number));
	}
}
