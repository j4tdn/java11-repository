package immutable;

public class Ex04 {
	public static void main(String[] args) {
		String[] books = { "SGK123", "STK234", "SGK357" };

		// Get classical book
		for (String book : books) {
			if (book.startsWith("SGK")) {
				System.out.println(book);
			}
		}

		String layout = "GridLayout";
		layout = layout.replace("Grid", "Border");

		System.out.println("Layout : " + layout);

		String hobbies = "Football , ,    Volleyball      Badminton";
		hobbies = hobbies.replaceAll("[\\s,]+", " ");
		System.out.println(hobbies);

		String parent = "abcdefghklm";
		String sub = parent.substring(2, 7);
		System.out.println(sub);

		char[] chars = parent.toCharArray();
		System.out.println("16 :" + chars[6]);
		System.out.println("16 :" + parent.charAt(6));

		String[] employee = { "EMP01", "Adam", "2500", "NewYork" };
		String result = "";
		for (String attribute : employee) {
			result += "-" + attribute;
		}
		System.out.println("result 1 : " + result);
		result = String.join("-", employee);
		System.out.println("result 2 : " + result);

//		System.out.println("sum " + sum(6,7));
//		System.out.println("sum " + sum(6,7,8,9,10));
//		System.out.println("sum " + sum(6));
	}

	// -> . ... ::
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
