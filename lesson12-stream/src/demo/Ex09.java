package demo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import bean.Dish;
import utils.DishUtils;

public class Ex09 {
	public static void main(String[] args) {
		List<Integer> digits = Arrays.asList(1,2,1,3,2,3,4);
		
		Set<Integer> uniqueNumber = new HashSet<>();
		
		Set<Integer> sdigits = digits.stream().filter(t -> t % 2 == 0 && !uniqueNumber.add(t))
		 .collect(Collectors.toSet());
		digits.stream().filter(t -> t % 2 == 0 && sdigits.add(t)).forEach(System.out::println);
		
		System.out.println("==========================================");
		List<Dish> dishs = DishUtils.getAll();
		
		Set<Double> test = new HashSet<>();
		Set<Dish> sdishs = dishs.stream().filter(d -> !test.add(d.getCalories())).collect(Collectors.toSet());
		dishs.stream().filter(d -> sdishs.add(d)).forEach(System.out::println);;
	}
	
}
