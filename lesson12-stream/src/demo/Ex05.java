package demo;

import java.util.function.Supplier;

import bean.Apple;
import functional.BiFunction;
import functional.BuFunction;

public class Ex05 {
	public static void main(String[] args) {
		// Constructor reference
		// empty constructor ()->new Apple = Apple::new

		Supplier<Apple> supplier = Apple::new;
		Apple a1 = supplier.get();

		System.out.println(a1);

		// Full constructor

//		BuFunction<Apple, Integer, String, Double, String> buFunction = new BuFunction<Apple, Integer, String, Double, String>() {
//
//			@Override
//			public Apple get(Integer id, String color, Double weight, String country) {
//
//				return new Apple(id, color, weight, country);
//			}
//		};
		BuFunction<Apple, Integer, String, Double, String> buFunction = Apple::new;
		Apple a2 = buFunction.get(1, "black",12d, "VietNam");
		System.out.println(a2);
		
		BiFunction<Apple, Integer, String> biFunction = Apple::new;
		Apple a3 = biFunction.get(2, "ThaiLand");
		System.out.println(a3);
	}
}
