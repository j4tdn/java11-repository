package demo;

import java.util.function.Supplier;

import bean.Apple;
import functional.BiFunction;
import functional.BuFunction;

public class Ex05 {
	public static void main(String[] args) {
		//Constructor reference
		//Empty constructor() -> new Apple  = Apple::new
		Supplier<Apple> supplier = Apple::new;
		Apple apple = supplier.get();
		System.out.println(apple);
		
		//2
		BiFunction<Apple, Integer, String> biFunction = Apple::new;
		
		Apple apple3 = biFunction.get(3, "Thailand");
		System.out.println(apple3);
		
		//full 
		BuFunction<Apple, Integer , String, Double, String> buFunction1 = Apple::new;
		Apple apple2 = buFunction1.get(2, "Black", 12d, "VietNam");
		System.out.println(apple2);
		
}
}