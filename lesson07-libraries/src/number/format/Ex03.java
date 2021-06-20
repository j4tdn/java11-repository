package number.format;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Ex03 {
	public static void main(String[] args) {
		BigDecimal b1 = BigDecimal.valueOf(1234566436677787.25367);
		BigDecimal b2 = BigDecimal.valueOf(12343.3244);
		
		BigDecimal result = b1.multiply(b2).setScale(6, RoundingMode.HALF_UP);
		
		System.out.println("result: " + result);
	}
}