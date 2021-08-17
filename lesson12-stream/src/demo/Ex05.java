package demo;

import java.util.function.Supplier;

import bean.Apple;
import functional.BiFunction;
import functional.BuFunction;

public class Ex05 {
	public static void main(String[] args) {
		// constructor reference
		// empty constructor ()->new Apple = Apple::new
		
		Supplier<Apple> supplier = Apple::new;
		Apple apple = supplier.get();
		System.out.println(apple);
		
		BuFunction<Apple, Integer, String, Double, String> buFunction = Apple::new;
		Apple a2 = buFunction.get(1, "black", 12d, "vn");
		System.out.println(a2);
		
		BiFunction<Apple, Integer, String> biFunction = Apple::new;
		Apple a3 = biFunction.get(1, "vn");
		System.out.println(a3);
	}
}
