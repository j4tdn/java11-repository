package demo;

import java.util.function.Supplier;

import bean.Apple;

public class Ex05 {
	public static void main(String[] args) {
		// Constructor reference
		// Empty construcotr () -> new Apple() = Apple::new
		Supplier<Apple> supplier = Apple::new;
		 
	}
}
