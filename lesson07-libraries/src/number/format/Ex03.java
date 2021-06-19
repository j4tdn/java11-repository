package number.format;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Ex03 {
	public static void main(String[] args) {
		BigDecimal b1 = BigDecimal.valueOf(12343434.1223);
		BigDecimal b2 = BigDecimal.valueOf(243.322);
		
		BigDecimal result = b1.multiply(b2).setScale(6, RoundingMode.UP);
		System.out.println("result: " + result);
		
		
	}

}
