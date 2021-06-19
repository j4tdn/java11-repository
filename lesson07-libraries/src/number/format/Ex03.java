package number.format;

import java.math.BigDecimal;
import java.math.RoundingMode;

// Big decimal
public class Ex03 {
	public static void main(String[] args) {
		BigDecimal b1 = BigDecimal.valueOf(123456487.25358);
		BigDecimal b2 = BigDecimal.valueOf(1234.358);

		BigDecimal result = b1.multiply(b2);
		result = result.setScale(3, RoundingMode.HALF_UP);
		System.out.println(result);
		
	}
}
