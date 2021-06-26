package bt;

public class Bt01 {
	public static void main(String[] args) {
		System.out.println("1: Show each character");
		String s = "Welcome to JAVA10";
		for (int i = 0; i < s.length(); i++) {
			System.out.println(" " + s.charAt(i));
		}

		System.out.println("2: Show each words");
		for (String s1 : s.split("\\s+")) {
			System.out.println(" " + s1);
		}

		System.out.println("3: Show reverse chars of string");
		StringBuffer s2 = new StringBuffer(s);
		System.out.println(s2.reverse());

		System.out.println("4: Show reverse words of string");
		for (String s3 : s.split("\\s+")) {
			System.out.print(" " +(new StringBuilder().append(s3).reverse()));
		}

	}
}
