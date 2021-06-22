package immutable;

public class Ex04 {
	public static void main(String[] args) {
		String[] books = { "SGK123", "STK234STK", "SKG223" };

		// get classical book
		// startWith, endWhih, contains(chua gia tri)
		for (String book : books) {
			if (book.startsWith("STK")) {
				System.out.println(book);
			}
		}
		String layout = "GridLayout";
		layout = layout.replace("Grid", "Border");
		System.out.println("layout: " + layout);

		String hobbies = "Football,     Volleyball,      Badminton,   Game";
		hobbies = hobbies.replaceAll("[,\\s]+", " ");
		System.out.println("hobbies: " + hobbies);

		String parent = "abcdefghklm";
		CharSequence sub = parent.substring(2, 7);
		System.out.println("sub: " + sub);

		char[] chars = parent.toCharArray();
		System.out.println(chars[6]);
		System.out.println(parent.charAt(6));

		String[] employee = { "EMP01", "Adam", "2500", "Newyork" };
		String result = "";
		for (String attribute : employee) {
			result += "_" + attribute;
		}
		System.out.println("result1:" + result);
		result = String.join("EMP01", "Adam", "2500", "Newyork");
		System.out.println("result 2: " + result);
	}

	// variables...
//... stands for array|| set of 1 or n element
	public static int sum(int... elements) {
		int result = 0;

		for (int element : elements) {
			result += element;
		}
		return result;
	}

}
