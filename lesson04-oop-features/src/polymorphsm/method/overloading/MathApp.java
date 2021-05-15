package polymorphsm.method.overloading;

public class MathApp {
	public static void main(String[] args) {
		MathUtils.sum2So(2f, 4f);
		MathUtils.sum2So(2, 4);
		MathUtils.sum3So(0, 0, 0);
		MathApp ma = new MathApp();
		
		ma.printf("App");
		System.out.println(ma);// so sanh hai doan cham toString hay khong
		System.out.println(ma.toString());
	}
	
	private void printf(String input) {
		System.out.println(input);
	}
	@Override
	public String toString() {
		// this: la doi tuong hien tai
		// super: parent's methods
		return "MathApp >> toString...";
	}

}
