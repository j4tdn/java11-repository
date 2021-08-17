package demo;

import java.util.function.Supplier;

import bean.Apple;
import functional.BiFunction;
import functional.BuFunction;

public class Ex05 {
	public static void main(String[] args) {
		// Constructor reference >> Type Reference
		
		//Empty 
		Supplier<Apple> supplier = Apple:: new;
		Apple a1 = supplier.get();
		System.out.println(a1);
		
		BiFunction<Apple, Integer, String> biFunction = Apple:: new;
		Apple a2 = biFunction.get(2, "ThaiLand");
		System.out.println(a2);
		
		BuFunction<Apple, Integer, String, Double, String> buFunction = Apple :: new;
		Apple a3 = buFunction.get(3, "nice", 15000d, "VietNam");
		System.out.println(a3);
	}
}
