package number.format;

import java.text.DecimalFormat;

public class Ex02 {
	private static final String PATTERN = " #,###.00";
	//0,###.0000 => loi
	//0,000.0000 => khong loi
	public static void main(String[] args) {
		
		double number = 2322121234.23323455;
		double number1 = 34.23323455;
		
		DecimalFormat decimalFormat = new DecimalFormat(PATTERN);
		
		System.out.println("Number: " + decimalFormat.format(number));
		System.out.println("Number: " + decimalFormat.format(number1));
	}

}
