package demo;

import java.util.function.Supplier;

import bean.Apple;
import functional.BiFunction;
import functional.BuFunction;

public class Ex05 {
	public static void main(String[] args) {
		// Constructor reference
		// Empty constructor () -> new Apple() = Apple::new;
		Supplier<Apple> supplier = Apple::new;
		Apple apple = supplier.get();
		
		System.out.println(apple);
		
		// full constructor
		BuFunction<Apple, Integer, String, Double, String> buf =  Apple::new;
		
		Apple a =  buf.get(1, "green", 12d, "VietNam");
		
		BiFunction<Apple, Integer, String> bif = Apple::new;
		Apple b = bif.get(2, "ThaiLan");
	}
}
