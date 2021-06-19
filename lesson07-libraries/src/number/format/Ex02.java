package number.format;

import java.text.DecimalFormat;

public class Ex02 {
	// #,###.###
	// #.###,### - Pattern Error
	// 0,000.000
	// #,###.000
	// #,##0.000
	// 0, ###.00000 - Error
	private static final String PATTERN = "0,###.00";
			
	public static void main(String[] args) {
		double number = 7.6824;
		DecimalFormat fm = new DecimalFormat(PATTERN);
		System.out.println("value: " + fm.format(number));
	}
}
