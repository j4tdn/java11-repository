package number.format;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class Ex03 {
	public static void main(String[] args) {
		// BigInteger
		BigDecimal b1 = BigDecimal.valueOf(12365989.25358);
		BigDecimal b2 = BigDecimal.valueOf(599.2258);

		BigDecimal result = b1.multiply(b2).setScale(6, RoundingMode.HALF_UP);
		System.out.println("result: " + result);

	}
}
