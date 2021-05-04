package demo;

import bean.Car;

public class Ex03Equals {
	public static void main(String[] args) {
		Car c1 = new Car("123", "Audi", "Gray");
		Car c2 = new Car("234", "Lambo", "While");
		Car c3 = new Car("123", "Audi", "Gray");
		printEqual(c1,c2);
		printEqual(c3,c2);
		printEqual(c1,c3);
		
	}
	private static void printEqual(Car c1 , Car c2) {
		System.out.println(c1.equals(c2));
	}
	private static void hash(String text, Car c) {
		System.out.println(text + ": " +System.identityHashCode(c));
	}
}
