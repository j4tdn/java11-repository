package number.format;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class Ex03 {
	public static void main(String[] args) {
		BigDecimal b1 = BigDecimal.valueOf(1246552554.25354);
		BigDecimal b2 = BigDecimal.valueOf(514.45454);
		
		BigDecimal result = b1.multiply(b2).setScale(6, RoundingMode.HALF_UP);
		
		System.out.println("result: " + result);		
	}
}
