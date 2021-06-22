package immutable;

public class Ex04 {
	public static void main(String[] args) {
		String[] books = { "abSGK123", "abc234STK", "SGK223" };

		// Get classical book
		// startWith, endWith, contains
		for (String book : books) {
			if (book.contains("SGK")) {
				System.out.println(book);
			}
		}

		System.out.println("=====================");

		String layout = "GridLayout";
		layout = layout.replace("Grid", "Border");

		System.out.println("layout: " + layout);

		System.out.println("=====================");

		// abc1234@nn.com
		// [a-z01-9]+[a-z01-9].[a-z]+
		String hobbies = "Football,,,    Volleyball,    Badminton, Game";
		// hobbies = hobbies.replaceAll("\\s{1,}", " ");
		hobbies = hobbies.replaceAll("[,\\s]+", " ");
		System.out.println("hobbies: " + hobbies);

		System.out.println("=====================");

		String parent = "abcdefghklm";
		CharSequence sub = parent.subSequence(2, 7);
		System.out.println("sub: " + sub);

		System.out.println("=====================");

		char[] chars = parent.toCharArray();
		System.out.println("i6: " + chars[6]);
		System.out.println("c6: " + parent.charAt(6));

		System.out.println("=====================");

		String[] employee = { "EMP01", "Adam", "2500", "NewYork" };
		String result = "";
		for (String attribute : employee) {
			result += "-" + attribute;
		}
		System.out.println("result 1: " + result);
		result = String.join("-", employee);
		System.out.println("result 2: " + result);
		
		System.out.println("=====================");

		int[] e1 = { 2, 3 };
		int[] e2 = { 2, 3, 4 };
		System.out.println("sum: " + sum(e1));
		System.out.println("sum: " + sum(e2));
		System.out.println("sum: " + sum(1, 1, 36));

	}

	// variables ...
	// ... stands for array || set of 1 or n elements
	public static int sum(int... elements) {
		int result = 0;
		for (int element : elements) {
			result += element;
		}
		return result;
	}
}
