package collection.list;

import java.util.ArrayList;
import java.util.List;

public class Ex02 {
	public static void main(String[] args) {
		//Generic typeL >=1.5
		// catch error at compile time
		ArrayList<Double> a = new ArrayList<Double>();//never use
		
		
		List<Integer> digits = new ArrayList<>();// chi cho tu vesion 1.5
		List<String> sequences = new ArrayList<String>();// chi cho tu vesion 1.5
		
		digits.add(123);
		digits.add(234);
		
		for (Integer digit : digits) {
			System.out.println("double: " + (digit *2));
		}
	}

}