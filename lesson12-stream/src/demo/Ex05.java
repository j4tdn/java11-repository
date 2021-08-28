package demo;

import java.util.function.Supplier;

import bean.Apple;

public class Ex05 {
	public static void main(String[] args) {
		// Constructor reference
		
		 Supplier<Apple> supplier = new Supplier<Apple>() {
			
			@Override
			public Apple get() {
				return new Apple();
			}
		};
	}
}
