package immutable;

public class Ex04 {
	public static void main(String[] args) {
		String[] books = { "SGK123", "STK234", "SGK223" };

		// get classical books
		// startWith, endWith, contains
		for (String book : books) {
			if (book.startsWith("SGK")) {
				System.out.println(book);
			}
		}

		System.out.println("=========");
		String layout = "Grid Layout";
		layout = layout.replace("Grid", "Boder");
		System.out.println("layout: " + layout);

		String hoobies = "Football,,,    Volleyball    Game";
		hoobies = hoobies.replaceAll("[,\\s+]", " ");
		System.out.println("hobbies: " + hoobies);

		String parent = "abcdefghjkl";
		CharSequence sub = parent.subSequence(2, 7);
		System.out.println("sub: " + sub);

		char[] chars = parent.toCharArray();
		System.out.println("i6: " + chars[6]);
		System.out.println("c6: " + parent.charAt(6));

		String[] employee = { "EMP01", "A", "2500", "NY" };
		String result = "";
		for (String attribute : employee) {
			result += "-" + attribute;
		}
		System.out.println("result 1: " + result);

		result = String.join("-", employee);
		System.out.println("result 2: " + result);
	}
}
