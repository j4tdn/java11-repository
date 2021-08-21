package demo;

import java.util.function.Supplier;

import bean.Apple;
import functional.BiFunction;
import functional.BuFunction;

public class Ex05 {
	public static void main(String[] args) {
		// Constructor reference
		// Empty constructor () -> new Apple() = Apple:new
		//
		Supplier<Apple> supplier = new Supplier<Apple>() {
			@Override
			public Apple get() {
				return new Apple();
			}
		};
		Apple a1 = supplier.get();
		Supplier<Apple> supplier1 = () -> new Apple();
		Supplier<Apple> supplier2 = Apple::new;
		System.out.println(a1);
		
		BiFunction<Apple, Integer, String> biFunction = Apple::new;
		Apple a4 = biFunction.get(2, "Thailand");

		// Full constructor (Integer id, String color, Double weight, String country) ->
		// new Apple(id, color, weight, country)
		BuFunction<Apple, Integer, String, Double, String> buFunction = new BuFunction<>() {
			@Override
			public Apple get(Integer id, String color, Double weight, String country) {

				return new Apple(id, color, weight, country);
			}
		};
		Apple a2 = buFunction.get(1, "black", 12d, "Vietnam");
		// Short code
		BuFunction<Apple, Integer, String, Double, String> buFunction1 = Apple::new;
		Apple a3 = buFunction1.get(1, "Black", 12d, "Vietnam");
		System.out.println(a3);
		
		
		
	};
}
