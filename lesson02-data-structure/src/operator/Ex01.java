package operator;

public class Ex01 {
	public static void main(String[] args) {
		int n = 7;
		boolean isEven = isEven(n);
		if(isEven) {
			System.out.println(n + " is even number");
		}
		else {
			System.out.println(n + " is odd number");
		}
		System.out.println(n + " is " + (isEven ? "even" : "odd") + " number");
		
		if(n % 2 == 0 && n % 10 == 0) {
			System.out.println("true");
		}
	}
    private static boolean isEven(int input) {
    	return input % 2 == 0; 
    }
}
