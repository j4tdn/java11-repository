package collection.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Ex01 {
	public static void main(String[] args) {
		// Prior to 1.5
		List l1 = new ArrayList();
		// no elements
		// required: List of numbers
		// output: double of numbers

		List l2 = new LinkedList();
		List l3 = new Stack();

		// boxing int -> Integer, unboxing Integer -> int

		// using l1
		l1.add("element");
		l1.add(new Integer(10));

		System.out.println("l1 size: " + l1.size());

		for (int i = 0; i < l1.size(); i++) {
			// cause runtime error
			System.out.println(i + ": " + Integer.parseInt(l1.get(i).toString()) * 2);
		}

	}
}