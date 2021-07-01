package format;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Ex03 {
	public static void main(String[] args) {
		BigDecimal digit = BigDecimal.valueOf(21346345689.568318d);
		System.out.println("digit: " + digit);
		// Rounding 
		digit = digit.setScale(5, RoundingMode.HALF_UP);
		System.out.println(digit);
		System.out.println();
	}
}
