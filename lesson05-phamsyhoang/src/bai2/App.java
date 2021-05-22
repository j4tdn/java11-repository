package bai2;

public class App {
	public static void main(String[] args) {
		Integer n = 6;
		Integer[] A = { 3, 2, 1, 6, 5 };
		getMissingNumber(n, A);
		

	}

	public static int getMissingNumber(Integer n, Integer[] arr) {
		int thieu_sum=0;
		for(int i=0;i<arr.length;i++) {
			thieu_sum+=arr[i];
		}
		int real_sum=0;
		for(int j=0;j<=n;j++) {
			real_sum+=j;
		}
		System.out.println(real_sum-thieu_sum);

		return real_sum-thieu_sum;
	}
}
