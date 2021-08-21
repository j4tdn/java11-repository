package demo;

import java.util.function.Supplier;

import bean.Apple;
import functional.BiFunction;
import functional.BuFunction;

public class Ex05 {
	public static void main(String[] args) {
		// Constructor reference
		// Empty constructor () -> new Apple() = Apple::new
		
		Supplier<Apple> supplier = Apple::new;
		Apple a1 = supplier.get();
		System.out.println(a1);
		
		
//		BuFunction<Apple, Integer, String, Double, String> buFunction = new BuFunction<Apple, Integer, String, Double, String>() {
//		
//		@Override
//			public Apple get(Integer id, String color, Double weight, String country) {
//				return new Apple(id, color, weight, country);
//			}
//		};
		
		BiFunction<Apple, Integer, String> biFunction = Apple::new;
		Apple a2 = biFunction.get(1, "ThaiLan");
		System.out.println(a2);
		
		// Full contructor = (Integer id, String color, Double weight, String country) -> new Apple(id, color, weight, country);
		BuFunction<Apple, Integer, String, Double, String> buFunction = Apple::new;
		Apple a3 = buFunction.get(1, "black", 12d, "VietNam");
		System.out.println(a3);
		
		
	}
}