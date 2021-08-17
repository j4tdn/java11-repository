package demo;

import java.util.function.Supplier;

import bean.Apple;
import functional.BiFunction;
import functional.BuFunction;

public class Ex05 {
	public static void main(String[] args) {
		// Constructor reference
		// Empty constructor  () -> new Apple() = Apple::new
		
		Supplier<Apple> supplier = Apple::new;
		Apple apple = supplier.get();
		System.out.println(apple);
		
		BiFunction<Apple, Integer, String> biFunction = Apple::new;
		Apple a2 = biFunction.get(2, "Thailand");
		System.out.println(a2);
		
		// Full constructor (Integer id, String color, Double weight, String country) -> new Apple(id, color, weight, country);
		BuFunction<Apple, Integer, String, Double, String> buFunction = Apple::new;
		Apple a3 = buFunction.get(1, "black", 12d, "Vietnam");
		System.out.println(a3);
	}
}
