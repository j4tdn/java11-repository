package ex01;

import java.util.Arrays;

public class Ex01 {
	public static void main(String[] args) {
		int[] array = {7, 8, 8, 8, 6, 2, 5, 1};
		System.out.println("3rd largest number: " + thirdLargest(array));
	}
	
    private static int thirdLargest(int[] array) {
        Arrays.sort(array);
        return array[array.length - 3];
    }
}
