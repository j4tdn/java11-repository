package exercise;

public class Ex04 {
	public static void main(String[] args) {
		int[] a = { 1, 2, 8 };
		System.out.println(getLeastCommonMultiple(a));

	}

	public static int getLeastCommonMultiple(int[] a) {
		int temp = bcnn(a[0], a[1]);
		for (int i = 2; i < a.length; i++) {
			temp = ucln(temp, a[i]);
		}
		return temp;
	}

	public static int ucln(int a, int b) {
		if(a == b) return a;
		if(a > b) return ucln(a-b,b);
		else return ucln(a, b-a);
	}
	

	public static int bcnn(int a, int b) {
		return (a * b / ucln(a, b));
	}
}
