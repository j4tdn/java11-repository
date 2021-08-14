package demo;

import java.util.ArrayList;
import java.util.List;

import bean.Apple;
import bean.Strategy;
import utils.AppleUtils;
import utils.CollectionUtils;

public class Ex02 {
	public static void main(String[] args) {
		List<Apple> inventory = AppleUtils.getAll();
		
		 
		System.out.println("=================GREEND APPLE==============");
		List<Apple> green = filterApples(inventory, a -> "green".equals(a.getColor()));
		CollectionUtils.printf(green);
		
		System.out.println("=================GREEND APPLE==============");
		List<Apple> red = filterApples(inventory, a -> "red".equals(a.getColor()));
		CollectionUtils.printf(red);
		
		
	}
	/**
	 * Get apple wwith given condition
	 * 
	 * @param inventory input data
	 * @param behavior given condition
	 * @return output data
	 */
	private static List<Apple> filterApples(List<Apple> inventory,Strategy<Apple> strategy){
		List<Apple> rs = new ArrayList<Apple>();
	
		for(Apple apple : inventory) {
			if(strategy.test(apple)) {
				rs.add(apple);
			}
		}
		return rs;
	}
	