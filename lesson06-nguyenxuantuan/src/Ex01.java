import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		float a = input("a");
		float b = input("b");
		solve(a, b);
	}
	
	public static float input(String s) {
		Scanner sc = new Scanner(System.in);
		float a = 0;
		do {
			System.out.printf("nhap " + s + " = ");
			try {
				a = Float.parseFloat(sc.nextLine());
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (true);
		
		return a;
	}
	
	private static void solve(float a, float b) {
		float result = 0;
		do {
			try {
				result = (int)-b/(int)a;
				break;
			} catch (ArithmeticException e) {
				System.out.println(e.getMessage());
				a = input("a");
			}
		} while(true);
		result = -b/a;
		System.out.println("ket qua: "+ result);
	}
	
}

