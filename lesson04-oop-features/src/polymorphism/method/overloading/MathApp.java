package polymorphism.method.overloading;

public class MathApp {
	public static void main(String[] args) {
		MathUtils.sum(5, 6);
		MathUtils.sum(4, 50, 60);

		MathApp ma = new MathApp();

		ma.printf("app");
		System.out.println(ma); // to string : object
		System.out.println(ma.toString()); // to string : object
	}

	private void printf(String input) {
		System.out.println(input);
	}

	@Override
	public String toString() {
		// this: doi tuong hien tai(current object)
		// super: parent method
		return "MathApp >> toString...";
	}
}
