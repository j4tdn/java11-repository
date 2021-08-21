package demo;

import java.util.function.Supplier;

import bean.Apple;
import functional.BiFunction;
import functional.BuFunction;

public class Ex05 {
	public static void main(String[] args) {
		// Constructor reference >> Type Reference
		// Empty constructor () -> new Apple() = Apple::new
		Supplier<Apple> supplier = Apple::new;
		Apple a1 = supplier.get();
		System.out.println(a1);
		
		// 
		BiFunction<Apple, Integer, String> biFunction = Apple::new;
		Apple a2 = biFunction.get(1, "Viet Nam");
		System.out.println(a2);
		
		// Full constructor
		BuFunction<Apple, Integer, String, Double, String> buFunction = Apple::new;
		Apple a3 = buFunction.get(2, "Black", 12d, "Viet Nam");
		System.out.println(a3);
	}
}