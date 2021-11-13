package immutable;

import bean.Item;

public class Ex02 {
	public static void main(String[] args) {
		String l1 = "one";
		String l2 = "two";
		String l3 = "three";

		String l4 = "two";

		String o1 = new String("mot");
		String o2 = new String("hai");
		String o3 = new String("ba");
		String o4 = new String("hai");
		
		System.out.println("(l1==l2): " + (l1 == l2));
		System.out.println("(l1==l3): " + (l1 == l3));
		System.out.println("(l1==l4): " + (l1 == l4));
		System.out.println("(l2==l4): " + (l2 == l4));

		System.out.println("(o1==o2): " + (o1 == o2));
		System.out.println("(o1==o3): " + (o1 == o3));
		System.out.println("(o1==o4): " + (o1 == o4));
		System.out.println("(o2==o4): " + (o2 == o4));

		System.out.println("==========EQUALS==========");
		System.out.println("(l1 eq l2): " + (l1.equals(l2))); // F
		System.out.println("(l1 eq l3): " + (l1.equals(l3))); // F
		System.out.println("(l1 eq l4): " + (l1.equals(l4))); // F
		System.out.println("(l2 eq l4): " + (l2.equals(l4))); // T

		System.out.println("(o1 eq o2): " + (o1.equals(o2))); // F
		System.out.println("(o1 eq o3): " + (o1.equals(o3))); // F
		System.out.println("(o1 eq o4): " + (o1.equals(o4))); // F
		System.out.println("(o2 eq o4): " + (o1.equals(o4))); // T
		
		
		Item i1 = new Item(1,"A",11d);
		Item i2 = new Item(2,"B",22d);
		Item i3 = new Item(1,"A",11d);
		
		System.out.println("(i1==i2): "+(i1==i2));
		System.out.println("(i1==i3): "+(i1==i3));
		// default equals <=> object#equals => similar
		System.out.println("(i1 eq i2): "+(i1.equals(i2)));
		System.out.println("(i1 eq i3): "+(i1.equals(i3)));
		System.out.println("==========COMPARETO==========");
		//System.out.println("A cpt D: "+("A".compareTo(o4)));
	}
}
