package collection.list;

import java.util.ArrayList;
import java.util.List;

public class Ex02 {
	public static void main(String[] args) {
		
		//Generic type >= 1.5 version 
		//Catch error at compile time 
	// k lam kieu nay
	//	ArrayList<Double> a = new ArrayList<>();
		
		List<Integer> digits = new ArrayList<>();
		List<String> sequences = new ArrayList<String>();
		
		digits.add(123);
		digits.add(234);
		
		for(Integer digit: digits) {
			System.out.println("double: " + (digit*2) );
		}
//		for (int i = 0; i < digits.size(); i++) {
//			System.out.println("double: " + digits.get(i) * 2);
//		}
		
		
	}
}