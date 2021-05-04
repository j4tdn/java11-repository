package demo;

public class Ex02 {
	//how many objects were created?
	public static void main(String[] args) {
		Integer  a = 10; //+
		String b = new String("Hello"); //+ : khong nen dung
		float c = 10.2f; // khong co doi tuong dc tao ra
		Double d = 7d; //+
		Rectangle r1 = null; //khong co doi tuong dc tao ra
		Rectangle r2 =new Rectangle(); //+
		Rectangle r3 = r2; // khong co doi tuong dc tao ra, chi gan gia tri o stack
		String f = "Welcome"; //+
		//=> having 5 objects were created
	}
}
