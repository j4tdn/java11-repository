package immutable;

public class Ex04 {
	public static void main(String[] args) {
		String[] books = {"SGK123", "STK234", "SGK223"};
		
		// Get classical book
		for (String book: books) {
			if (book.startsWith("STK")) {
				System.out.println(book);
			}
		}
		System.out.println("============");
		String layout = "GridLayout";
		layout = layout.replace("Grid", "Border");
		System.out.println(layout);
		
		String hobbies = "Football,,,,,    Volleyball,,,   Badminton";
		hobbies = hobbies.replaceAll("[,\\s]+", " ");
		System.out.println("hobbies: " + hobbies);
		
		String parent = "abcdefghklm";
		CharSequence sub = parent.substring(2, 7);
		System.out.println(sub);
		
		char[] chars = parent.toCharArray();
		System.out.println("i6: " + chars[6]);
		System.out.println("c6: " + parent.charAt(6));
		
		String[] employee = {"EMP01", "Adma", "2500", "Newyork"};
		String result = "";
		for (String attribute: employee) {
			result += "-" + attribute;
		}
		System.out.println("result 1: " + result);
		result = String.join("-", employee);
		System.out.println("result 2: " + result);
		
	}
	
	// ->.... ..::
	// variables ...
	// ... stands for array || set of 1 or n elements
}
