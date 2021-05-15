package polymorphism.method.overloading;

public class MathApp {
	public static void main(String[] args) {
		MathUtils.sum(5, 5);
		MathUtils.sum(5f, 5f);
		MathUtils.sum(5, 5, 5);

		MathApp ma = new MathApp();
		ma.printf("App");

		System.out.println(ma); // call toString in class object
		System.out.println(ma.toString()); // call toString in class object
	}

	private void printf(String input) {
		System.out.println(input);
	}
	
	@Override
	public String toString() {
		// this: to call methods in current object
		// super: to call methods in parents
		return "MathApp >> toString...";
	}
}
