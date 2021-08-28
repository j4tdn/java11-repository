package demo;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import bean.Dish;
import utils.ArrayUtils;
import utils.CollectionUtils;
import utils.DishUtils;

public class Ex08 {
	public static void main(String[] args) {
		// source: List<E>, E[]
		int[] digits = {1, 2, 1, 3, 3, 2, 4};
		
		// Stream Object: Stream<T>
		// Stream Primitive: IntStream, DoubleStream, LongStream
		
		int[] evenNumvers = Arrays.stream(digits)
			 .filter(digit -> digit%2==0)
			 .distinct()
			 .toArray();
		ArrayUtils.printf(evenNumvers);
		
		
		List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
		Set<Integer> evenNumbers =  numbers.stream()
											.filter(a -> a%2==0)
											.collect(Collectors.toSet());
		CollectionUtils.printf(evenNumbers);
		
		List<Dish> dish = DishUtils.getAll();
	}
}
