package immutable;

public class Ex03 {
	public static void main(String[] args) {
		String s1 = "Recycle View 8";
		System.out.println("length: " + s1.length());
		System.out.println("charAt3: " + s1.charAt(3));

		for (int i = 0; i < s1.length(); i++) {
			char tmp = s1.charAt(i);
			if (tmp >= '0' && tmp <= '9') {
				System.out.println(s1.charAt(i));
			}
		}

		s1 = s1.concat(" - Layout");// + operator || concatenate
		System.out.println("s1: " + s1);

		System.out.println("first 'c' position: " + s1.indexOf("c"));
		System.out.println("last 'c' position: " + s1.lastIndexOf("c"));

		int indexC = s1.indexOf("c");
		int lastC = s1.lastIndexOf("c");
		System.out.println("sub: " + s1.substring(indexC, lastC));
	}
}