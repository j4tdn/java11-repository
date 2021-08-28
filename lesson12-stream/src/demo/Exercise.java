package demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import bean.Dish;
import utils.CollectionUtils;
import utils.DishUtils;

public class Exercise {
	public static void main(String[] args) {
		List<Integer> digits = Arrays.asList(1, 2, 1, 3, 3, 2, 4, 5);
		List<Integer> appear1 = digits.stream()
									 .filter(i -> Collections.frequency(digits, i) == 1)
									 .collect(Collectors.toList());
		CollectionUtils.printf(appear1);
		
		List<Dish> dishes = DishUtils.getAll();
		List<Dish> calories = dishes.stream()
									.filter(i -> Collections.frequency(dishes, i) == 1)
									.collect(Collectors.toList());
		CollectionUtils.printf(calories);
	}
}
