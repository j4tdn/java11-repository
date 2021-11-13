package immutable;

public class Ex03 {
	public static void main(String[] args) {
		String s = "Box";
		
		System.out.println("Length: " + s.length());
		s = s + "Layout";
		System.out.println("2: " + s);

		System.out.println("charAt(4): " + s.charAt(4));
		for (int i = 0; i < s.length(); i++) {
			System.out.println(s.charAt(i) + "----");

		}
		System.out.println("\nindexof: " + s.indexOf("x"));
		System.out.println("\nindexof: " + s.indexOf("Box"));
		System.out.println("lastindexof: " + s.indexOf("t"));

	}
}
