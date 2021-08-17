package demo;

import java.util.function.Supplier;

import bean.Apple;
import functional.BiFunction;
import functional.BuFunction;

public class Ex05 {
	public static void main(String[] args) {
		// constructor reference >> type reference
		// empty constructor: () -> new Apple() = Apple::new

		Supplier<Apple> supplier = Apple::new;
		Apple a1 = supplier.get();
		System.out.println(a1);

		BiFunction<Apple, Integer, String> biFunction = Apple::new;
		Apple a2 = biFunction.get(2, "Thailand");
		System.out.println();

		// full constructor:(Integer id, String color, Double weight, String country) ->
		// new Apple(id, color, weight, country) = new Apple(id, color weight, conuntry)
		BuFunction<Apple, Integer, String, Double, String> buFunction = Apple::new;
		Apple a3 = buFunction.get(1, "black", 12d, "vietnam");
		System.out.println(a3);

	}
}
