package number.format;

import java.text.DecimalFormat;

public class Ex02 {
	private static final String PATTERN = "#,###.000";
	public static void main(String[] args) {
		double number = 123125422;
  DecimalFormat fm = new DecimalFormat();
  System.out.println("value: " + fm.format(number));
 }
}