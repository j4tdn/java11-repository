package collection.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Ex01 {
	public static void main(String[] args) {
		//Raw type	
		//Catch error at compile time 

		
		//Prior to 1.5 
		List l1 = new ArrayList(); //mac dinh: no elements 
		//required: list of numbers 
		//output: double(x2) of numbers
		
		List l2 = new LinkedList();
		List l3 = new Stack();

		//boxing int -> Integer, unboxing Integer -> int
		
		//Using L1
		l1.add("element");
		l1.add(new Integer(10));
		
		System.out.println("l1 size: " + l1.size());
		
		for( int i =0; i < l1.size(); i++) {
			//cause runtime error
			System.out.println(i + ": " + Integer.parseInt(l1.get(i).toString()) * 2);
		}
	}
}
