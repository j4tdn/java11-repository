package exercise3;

public class App {
	public static void main(String[] args) {
		int a = 6;
		int b = 2;
		System.out.println(a + " la luy thua cua " + b + ": " + isPowerOf(a, b));
	}
	public static boolean isPowerOf(int a, int b) {
		return (int)(Math.ceil((Math.log(a) / Math.log(b)))) 
	            == (int)(Math.floor(((Math.log(a) / Math.log(b)))));
	}
}
