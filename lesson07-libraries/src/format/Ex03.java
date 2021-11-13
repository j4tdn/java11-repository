package format;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;

public class Ex03 {
	public static void main(String[] args) {
		BigDecimal digit = BigDecimal.valueOf(56663234234234.5456456d);
		System.out.println("digit: "+digit);
		
		digit= digit.setScale(2,RoundingMode.HALF_UP);
		
		System.out.println("rouding: "+digit);
		Calendar c1 = Calendar.getInstance();
	
		Calendar c2 = Calendar.getInstance();
	}
}
