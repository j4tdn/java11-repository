package format;

import java.text.DecimalFormat;

public class Ex02 {
	private static String PATTERN ="#,###.00";
	public static void main(String[] args) {
		double digit =123456.2756d;
		DecimalFormat df = new DecimalFormat(PATTERN);
		
		System.out.println("df: "+df.format(digit));
	}
}
