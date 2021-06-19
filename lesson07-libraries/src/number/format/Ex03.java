package number.format;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Ex03 {
  public static void main(String[] args) {
	BigDecimal b1 = BigDecimal.valueOf(123549589.25248);
	BigDecimal b2 = BigDecimal.valueOf(564.4892);
	
	BigDecimal result = b1.multiply(b2).setScale(6, RoundingMode.HALF_UP);
	System.out.println("result: " + result);
	
}
}
