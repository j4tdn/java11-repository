package declaration;

import java.util.Arrays;

import funcion.Predicate;
import utils.ArrayUtils;

import static utils.ArrayUtils.*;

public class Ex02 {
  public static void main(String[] args) {
	int[] digits = {1,4,7,3,12,25};
	Predicate pre = x -> x % 2 == 0;
	// get odd elements in digits
	int[] oddElements = getElements(digits, x -> x % 2 == 0);
	int[] powerof3 = getElements(digits, x-> x%3 ==0);
	printf(oddElements);
	printf(powerof3);
	
}
  private static int[] getElements(int[] digits, Predicate predicate) {
	  // fixed - length
	  // should assign max containable length
	  int[] result = new int[digits.length];
	  int run =0;
	  for(int digit: digits) {
		  if(predicate.test(digit)) {
			  result[run++] = digit;
		  }
	  }
	  System.out.println("run: " + run);
	  return Arrays.copyOfRange(result, 0, run);
	  
  }
}
