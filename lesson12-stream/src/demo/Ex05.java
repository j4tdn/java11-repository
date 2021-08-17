package demo;

import java.util.function.Supplier;

import bean.Apple;
import functional.BiFunction;
import functional.BuFunction;

public class Ex05 {
	public static void main(String[] args) {
		// Constructor reference >> Type Reference
		// Empty constructor () -> new Apple() = Apple :: new
		Supplier<Apple> supplier = Apple::new;
		Apple a1 = supplier.get();
		System.out.println(a1);
		
		BiFunction<Apple, Integer, String> biFunction = Apple::new;
		Apple a3 = biFunction.get(2, "America");
		System.out.println(a3);
		
		// Full constructor (id, color, weight, country) -> new Apple(id, color, weight,
		// country);
		BuFunction<Apple, Integer, String, Double, String> buFunction = Apple::new;
		Apple a2 = buFunction.get(1, "black", 12d, "Vietnam");
		System.out.println(a2);
		
	}
}
