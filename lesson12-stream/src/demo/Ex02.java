package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import bean.Apple;
import bean.Strategy;
import utils.AppleUtils;
import utils.collectionUtils;

public class Ex02 {
	public static void main(String[] args) {
		List<Apple> inventory = AppleUtils.getAll();
		
		List<Apple> greenApples = filterApples(inventory, a->"green".equals(a.getColor()));
		
		System.out.println("==========greenApple===========");
		collectionUtils.printf(greenApples);
		
		List<Apple> heavyApples = filterApples(inventory, a->a.getWeight()>200 );
		System.out.println("==========greenApple===========");
		collectionUtils.printf(heavyApples);
		
		//lambda expression
		Predicate<Apple> p = (Apple a)->a.getWeight() > 0;
		
		Set<String> color = map(inventory, new Function<Apple, String>() {

			@Override
			public String apply(Apple a) {
				
				return a.getColor();
			}
			
		});
		collectionUtils.printf(color);
		
		
		System.out.println("======Map Lenght =========");
		List<String> texts = Arrays.asList("abc","acde","ac","acuegdaw");
		Set<Integer> lenghts = map(texts, s -> s.length());
		collectionUtils.printf(lenghts);
		
	}
	private static <T,R> Set<R> map(List<T> ts, Function<T, R> function){
		Set<R> result = new HashSet<>();
		// behavior(Apple): R
		for (T t : ts) {
			// apple -> country, id ,weight
			
			result.add(function.apply(t));
		}
		return result;
	}
	

	public static List<Apple> filterApples(List<Apple> inventory, Strategy<Apple> strategy){
		List<Apple> result = new ArrayList<Apple>();
		for (Apple apple : inventory) {
			if(strategy.behavior(apple)) {
				result.add(apple);
			}
		}
		return result;
	}
}
