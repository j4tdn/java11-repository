package demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import utils.ArrayUtils;
import utils.CollectionUtils;

public class Ex08 {
	public static void main(String[] args) {
		// source: List<E> , E[]
		int[] digits = {1,2,1,3,3,2,4};
		
		int[] evenNums = Arrays.stream(digits).filter(nbr -> nbr % 2 ==0)
						.distinct().toArray();
		ArrayUtils.printf(evenNums);
		
		/*List<Integer> numbers = Arrays.asList(1,2,1,3,3,2,4);
		
		Set<Integer> evenNums = numbers.stream()
									.filter(nbr -> nbr % 2 ==0)
									//.distinct()  //Set, Map, HashTable >> hashcode, equal
									.collect(Collectors.toSet());
		CollectionUtils.printf(evenNums);
	*/
		System.out.println("====================");
		//convert int[] -> List<Integer>
		List<Integer> numbers = Arrays.stream(digits).boxed().collect(Collectors.toList());
		
		List<Integer> uniqueNums = numbers.stream()
				.filter(nbr -> Collections.frequency(numbers, nbr)==1)
				.collect(Collectors.toList());
		CollectionUtils.printf(uniqueNums);
	}
}