package demo;

import java.awt.Desktop.Action;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

import bean.Apple;
import utils.AppleUtils;
import utils.collectionUtils;

public class Ex04 {
	public static void main(String[] args) {
		List<Apple> inventory = AppleUtils.getAll();
		// instance -> 	ClassA.[ClassB].method(instance)
		//ClassA.[ClassB]::method
		
		Consumer<Apple> c1 = a -> System.out.println(a);
		Consumer<Apple> c2 = System.out::println;
		
		inventory.forEach(System.out::println);
			
//		inventory.forEach(a -> System.out.print(a.getId()+ " "));
		
		//==============================================
		
		System.out.println("============== map lenght ==========");
		List<String> texts = Arrays.asList("abc","acde","ac","acuegdaw");
		Set<Integer> lenghts = collectionUtils.map(texts, String::length);
		collectionUtils.printf(lenghts);
		
		System.out.println("====== Map Colors =========");
		Set<String> colors = collectionUtils.map(inventory, Apple::getColor);
		collectionUtils.printf(colors);
		
		Function<String, Integer> f1 = s ->Integer.parseInt(s);

	}
	
	
}
