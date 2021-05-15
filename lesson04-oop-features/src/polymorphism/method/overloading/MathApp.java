package polymorphism.method.overloading;

public class MathApp {
	public static void main(String[] args) {
		MathUtils.sum(5, 5);
		MathUtils.sum(5f, 5f);
		MathUtils.sum(1, 1, 1);
	
		MathApp ma = new MathApp();
		ma.printf("App");
		System.out.println(ma);
	}
	
	private void printf(String input) {
		System.out.println(input);
	}
	
	@Override
	public String toString() {
		// this: current object
		// super: parent's method
		return "MathApp >> toString";
	}
}
