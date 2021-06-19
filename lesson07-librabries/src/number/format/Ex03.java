package number.format;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Ex03 {
	public static void main(String[] args) {
		BigDecimal b1 = BigDecimal.valueOf(11276.12112);
		BigDecimal b2 = BigDecimal.valueOf(25167.138);
		
		BigDecimal result =  b1.multiply(b2).setScale(6,RoundingMode.HALF_UP);
		// setScale :
		// RoundingMode: lam tron
		System.out.println("result:   " + result);
	}

}
