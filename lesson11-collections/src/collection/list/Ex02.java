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
		sequences.add("vo");
		sequences.add("dinh");
		sequences.add("trung ");
		
		for(Integer digit: digits) {
			System.out.println("double: " + (digit*2) );
		}
//		for (int i = 0; i < digits.size(); i++) {
//			System.out.println("double: " + digits.get(i) * 2);
//		}
		
		for(String element: sequences) {
			System.out.println(element);
		}
		
	}
}