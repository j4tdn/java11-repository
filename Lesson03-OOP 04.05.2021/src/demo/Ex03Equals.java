package demo;

import bean.Car;

public class Ex03Equals {
	public static void main(String[] args) {
		Car c1 = new Car("123", "Audi", "Gray");
		Car c2 = new Car("456", "Mazda", "Red");
		Car c3 = new Car("123", "Audi", "Gray");
		
		hash("C1",c1);
		hash("C2",c2);
		hash("C3",c3);
		
		printEquals(c1, c2);
		printEquals(c1, c3);
		printEquals(c2, c3);
		
		System.out.println(c1.equals(c2));
		System.out.println(c1.equals(c3));
		System.out.println(c2.equals(c3));
	}
	
	public static void printEquals(Car c1, Car c2) {
		System.out.println(c1 == c2);
	}
	
	public static void hash(String text, Car c) {
		System.out.println(text + ": " + System.identityHashCode(c));
	}
}
