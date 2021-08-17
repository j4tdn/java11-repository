package demo;

import java.util.function.Supplier;

import bean.Apple;
import functional.BuFunction;
import functional.EtFunction;

public class Ex05 {
	public static void main(String[] args) {
		// Constructor reference >> Type Reference
		// Empty constructor () -> new Apple() = Apple::new 

		Supplier<Apple> supplier = Apple::new;
		Apple apple = supplier.get();
		System.out.println(apple);
		
		// Full constructor
		BuFunction<Apple, Integer, String, Double, String> buFunction = Apple::new;
		Apple a2 = buFunction.get(1, "black", 12D, "Vietnam");
		System.out.println(a2);
		
		EtFunction<Apple, Integer, String> etFunction = Apple::new;
		Apple a3 = etFunction.get(2, "Thailand");
		System.out.println(a3);
		
		
	}
}
