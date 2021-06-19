package number.format;

import java.text.DecimalFormat;

public class Ex02 {
	private static final String PATTER = "#,###.00";
	public static void main(String[] args) {
		double number= 123543655465.2346d;
		DecimalFormat fm = new DecimalFormat(PATTER);
		
		System.out.println(fm.format(number));
		
	}
}
