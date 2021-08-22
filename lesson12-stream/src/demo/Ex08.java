package demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import bean.Dish;
import utils.ArrayUtils;
import utils.CollectionUtils;
import utils.DishUtils;

public class Ex08 {
	public static void main(String[] args) {
		// source: List<E>, E[]
		int[] digits = {1, 2, 1, 3, 3, 2, 4, 5, 4};

		// Stream Object; Stream<T>
		// Stream Primitive: IntStream, DoubleStream, LongStream
		// IntStream
		int[] evenNubmers = Arrays.stream(digits).filter(digit -> digit % 2 == 0).distinct().toArray();

		ArrayUtils.printf(evenNubmers);

		System.out.println("========================== ");
		/*
		 * List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
		 * 
		 * Set<Integer> evenNubmers = numbers.stream() .filter(number -> number % 2 ==
		 * 0) //.distinct() // Set, Map, HashTable >> hashcode ,equals
		 * .collect(Collectors.toSet());
		 * 
		 * CollectionUtils.printf(evenNubmers); System.out.println("runtime class: " +
		 * evenNubmers.getClass().getSimpleName());
		 */

		int[] uniqueNubmers = Arrays.stream(digits).filter(digit -> {
			int count = 0;
			for (int item : digits) {
				if (item == digit) {
					count++;
				}
				if (count > 1)
					return false;
			}
			return true;
		}).toArray();
		ArrayUtils.printf(uniqueNubmers);

		System.out.println("========================== ");
		
		List<Dish> dishs = DishUtils.getAll();
		List<Dish> uniquedishs = dishs.stream().filter(dish -> {
			int count = 0;
			for (Dish item : dishs) {
				if (dish.getCalories() == item.getCalories()) {
					count++;
				}
				if (count > 1)
					return false;
			}
			return true;
		}).collect(Collectors.toList());
		CollectionUtils.printf(uniquedishs);
	}

}
