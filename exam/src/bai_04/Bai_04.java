package bai_04;



public class Bai_04 {
	public static void main(String[] args) {
		int [] arr = new int [20];
		for (int i = 3; i < 20; i++) {
		    arr[i] = i;
		}
		System.out.println("BCNN mang: "+ BCNNmang(arr));
       
	}

	

	private static int UCLN(int a, int b) {
		if (a == b)
			return a;
		if (a > b)
			return UCLN(a - b, b);
		else
			return UCLN(a, b - a);
	}

	private static int BCNN( int a, int b) {
		return (a*b/UCLN(a, b));

	}
	private static int BCNNmang( int a[]) {
		int temp = BCNN(a[0],a[1] );
		for(int i = 2; i<a.length; i++) {
			temp = BCNN(temp, a[i]);
		}
		
		
		
		return temp;
		
		

	}
}