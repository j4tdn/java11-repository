package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import bean.Apple;
import bean.Strategy;
import utils.AppleUtils;
import utils.CollectionUtils;
/**
 * 
 * Get apple with given condition
 * 
 * @param behavior given condition
 * @param inventory input data
 * @return output data
 */
public class Ex02 {
	public static void main(String[] args) {
		List<Apple> inventory = AppleUtils.getAll();
		
		Strategy greenSty = new Strategy<Apple>() {
			
			@Override
			public boolean behavior(Apple apple) {
				return "green".equals(apple.getColor());
			}
		};
		
		List<Apple> greenApple = fiApples(inventory, greenSty);
		
		//anonimous class
		List<Apple> redApple = fiApples(inventory, apple ->  "red".equals(apple.getColor()));
			
		
		
			List<Apple> heaveApple = fiApples(inventory,apple ->apple.getWeight() > 300 );	 
			
		
		System.out.println("============Gren Apple============");
		CollectionUtils.printf(greenApple);
		System.out.println("=====================");
		
		System.out.println("============Red Apple============");
		CollectionUtils.printf(redApple);
		
		System.out.println("============Heavy Apple============");
		CollectionUtils.printf(heaveApple);
		
		
		System.out.println("==========Map of Apple==============");
		//Lambda Expression
		//Get list of origin countries of apples 
		//de luu phan tu k trung nhau dung Set
		Set<String> color = map(inventory, a -> a.getColor());
		CollectionUtils.printf(color);
		
		System.out.println("=========Map String ================");
		List<String> texts = Arrays.asList("abc", "abcd", "ab", "abcdef");
		//k dam bao vi tri phan tu dua vao
		Set<Integer> lengths = map(texts, s -> s.length());
		CollectionUtils.printf(lengths);
		
	}
	
	private static <T, R> Set<R> map(List<T> elements, Function<T, R> function) {
		Set<R> result = new HashSet<>();
		
		//behavior(T =Apple) : R >> apple.getCountry();
		for(T element : elements ) {
			//truyen vao apple -> country(String) || weight(Double) || id
			result.add(function.apply(element));
		}
		return result;
	}
	
	private static List<Apple> fiApples(List<Apple> inventory, Strategy<Apple> strategy){
		List<Apple> result = new ArrayList<>();
		for(Apple apple : inventory) {
			if(strategy.behavior(apple)) {
				result.add(apple);
			}
		}
		return result;
	}
}
