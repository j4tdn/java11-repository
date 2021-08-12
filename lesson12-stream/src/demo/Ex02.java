package demo;

import java.util.ArrayList;
import java.util.List;

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
