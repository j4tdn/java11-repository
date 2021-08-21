package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import utils.ArrayUtils;
import utils.CollectionUtils;

public class Ex08 {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,1,3,3,2,4);
		
		List<Integer> evenNumbers = numbers.stream()
											.filter(nbr -> nbr % 2 == 0)
											.distinct() //set, map, hashtable >> hashcode, equal
											.collect(Collectors.toList());
		
		CollectionUtils.printf(evenNumbers);
		
		int[] digits = {1,2,1,3,3,2,4};
		
		int[] evenNum = Arrays.stream(digits)
							  .filter(digit -> digit % 2 == 0)
							  .distinct()
							  .toArray();
		
		ArrayUtils.printf(evenNum);
	}
}
