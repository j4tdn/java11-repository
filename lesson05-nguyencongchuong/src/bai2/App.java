package bai2;

import java.util.Arrays;

public class App {
	public static void main(String[] args) {
		int numbers[]= {3, 7, 9, 2, 1, 6, 5, 4, 10};
        Arrays.sort(numbers);
        int i=1;

        while ( i < numbers.length ) 
        {
            if ( numbers[i] - numbers[i-1] == 1 ) 
            {
            } 
            else 
            {
                System.out.print( " " + ( numbers[i-1] + 1 ) );
            }
            i++;
        }
	}
}
