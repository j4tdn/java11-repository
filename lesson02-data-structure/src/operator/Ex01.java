package operator;

public class Ex01 {
	public static void main(String[] args) {
		int n = 10;
		System.out.println("isEven : " + isEven(n));

		////////////////
		System.out.println(n + " is " + (isEven(n) ? "even " : "odd") + " number");
	}

	private static boolean isEven(int input) {
		return input % 2 == 0 && input > 0;
	}
}
