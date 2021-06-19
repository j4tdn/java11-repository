package number.format;

import java.text.DecimalFormat;

public class Ex02 {
	private static final String PATTERN = "#,###.00"; ///0,000.00
	
	public static void main(String[] args) {
		double number = 12.2135;			//12121.2135
		DecimalFormat fm = new DecimalFormat(PATTERN);
		
		System.out.println("value: " + fm.format(number));
		
	}
}
