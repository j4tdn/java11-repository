package ex07;

import java.util.Arrays;

public class App {
	public static void main(String[] args) {
		String S = "aaaaabbbbcdsesseaaa";
		
		System.out.println("Max: " + Arrays.stream(trueSub(S)).max().getAsInt() );
		
		System.out.println("Min: "+ Arrays.stream(trueSub(S)).min().getAsInt());
		
		
	}
	private static int[] trueSub(String S) {
		int [] arr = new int[S.length()];
		int index = 0;
		char s = S.charAt(0);
		int count  = 1;
		
		for(int i = 1; i < S.length(); i++) {
			if(S.charAt(i) == s) {
				count ++;
			}
			else {
				arr[index ++] = count;
				count = 1;
				s = S.charAt(i);
			}
		}
		arr[index] = count;
		return Arrays.copyOfRange(arr, 0, index+1);
	}

}
