import exception.ZeroException;

public class Ex02 {
	public static void main(String[] args) {
		System.out.println("Main start");
		int a = 10;
		int b = 0;
		try {
			System.out.println("result: " + divide(a, b));
		} catch (ZeroException e) {
			e.printStackTrace();
		}
		System.out.println("Main end");
	}
	private static int divide(int a, int b) throws ArithmeticException{
		// throws RuntimeException >> no mandatory to handle exception
		if (b == 0) {
			// throw new ArithmeticException();
			// ZeroException
			throw new ArithmeticException("Please enter a non-zero value");
			// throw new ZeroException();
		}
		System.out.println("return a/b");
		return a/b;
	}
}
