package exercise;

public class Ex05_decimalToBinary {
	public static void main(String[] args) {
		int number = 10;
		convert(10);
		
		

	}
	
	private static void convert(int n) {
		int arr[] = new int[100];
		int i;
		for( i =0; n>0; i++) {
			arr[i] = n%2;
			n=n/2;
		}
		
		for(int j= i-1; i>=0; i--) {
			System.out.print(arr[i]);
		}
		
		
	}

}
