package ex02;

public class Ex02 {
	public static void main(String[] args) {
		int[] arr = {7, 5, 15, 3, 35, 10, 14, 2, 70, 105, 49, 13};
		collect(arr);
	}
	
	public static void collect(int[] arr) {
		for(int i = 0; i<arr.length; i++) {
			if (arr[i]%7==0 && arr[i]%5!=0) {
				System.out.print(arr[i]+" ");
			}
		}
		
		for(int i = 0; i<arr.length; i++) {
			if((arr[i]%5==0 && arr[i]%7==0) || (arr[i]%5!=0 && arr[i]%7!=0)) {
				System.out.print(arr[i]+" ");
			}
		}
		
		for(int i = 0; i<arr.length; i++) {
			if(arr[i]%5==0 && arr[i]%7!=0) {
				System.out.print(arr[i]+" ");
			}
		}
		
	}
}
