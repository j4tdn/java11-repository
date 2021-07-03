package ex01;

public class App {
	public static void main(String[] args) {
		String text = "Hoàng Thái Sơn";	
		StringBuilder strb = new StringBuilder();
		strb.append(text);
		char[] c = text.toCharArray();
		for(int i = 0; i < c.length; i++) {
			System.out.println(c[i]);
		}
		System.out.println("====================");
		for(int i = 0; i< c.length; i++) {
			System.out.print(c[i]);
			if(c[i]== ' ') {
				System.out.println("\n");
			}
		}
		System.out.println("\n====================");
		reverseChar(strb);
			
		System.out.println("\n====================");

		daochuoi((strb.reverse().reverse().toString()));
		}
	private static void reverseChar(StringBuilder strb) {
		System.out.println(strb.reverse());
	}
	private static void daochuoi(String text) {
		for(String i : text.split("\\s+")) {
			System.out.println( new StringBuilder().append(i).reverse());
		}
	}
}
