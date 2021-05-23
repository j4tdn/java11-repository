package exam4;

public class LeastCommonMulti {
	public static void main(String[] args) {
		int[] arr = {1, 3, 4, 10};
		int temp = getLeastCommonMtultiple(arr[0],arr[1]);
		for (int i = 2; i < arr.length; i++) {
			temp = getLeastCommonMtultiple(temp,arr[i]);
		}
		
		System.out.println("Least common multiple is: " + temp);
	}
	
	public static int UCLN(int a, int b) {
		if (b == 0) return a;
		return UCLN(b, a % b);
	}
	
	public static int getLeastCommonMtultiple(int a, int b) {
		return ((a*b)/UCLN(a,b));
	}
}
