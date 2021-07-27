package collection.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Ex01 {
	public static void main(String[] args) {
		List l1 = new ArrayList();
		List l2 = new LinkedList();
		List l3 = new Stack();

		l1.add("element");
		l1.add(new Integer(10));

		System.out.println(l1.size());

	}

}
