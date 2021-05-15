package polymorphism.methob.overloading;

public class MathApp {
	public static void main(String[] args) {
		MathUtils.sum2so(4,4);
		MathUtils.sum2so(5, 5);
		MathUtils.sum2so(5f, 5f);
		
		MathApp ma = new MathApp();
		ma.printf("App");
		
		System.out.println(ma);
		System.out.println(ma.toString());
	}
	private void printf(String input) {
		System.out.println(input);
	}
	
	
	@Override
	public String toString() {
		// this: current object
		// super: parent's methods
		return "MathApp >> toString ...";
	}

}
