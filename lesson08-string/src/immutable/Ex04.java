package immutable;

public class Ex04 {
	public static void main(String[] args) {
		String[] books = {"SGK123", "STK234", "SGK223"};
		
		// Get classical book 
		for (String book: books) {
			if (book.startsWith("SGK")) {
				System.out.println(book);
			}
			if (book.endsWith("SGK")) {
				System.out.println(book);
			}
			if (book.contains("SGK")) {
				System.out.println(book);
			}
		}
		
		String layout = "GridLayout";
		layout.replace("Grid", "Border");
		System.out.println("layout: " + layout);
		
		String hobbies = "Football        Volleyball   Badminton";
		hobbies = hobbies.replaceAll("\\s+", " ");
		
		hobbies = "Football, Volleyball, Badminton";
		hobbies = hobbies.replaceAll(", ", " ");
		
		hobbies = "Football,,, Volleyball,,   Badminton";
		hobbies = hobbies.replaceAll("[,\\s]+", " ");
		// 1 "," cung thay = space
		// 1 ", " cung thay = space
		// 1 " " cung thay = space
		System.out.println("hobbies: " + hobbies);
		
		String parent = "abcdeghklm";
		CharSequence sub = parent.substring(2, 7);
		System.out.println("sub: " + sub);
		
		char[] chars = parent.toCharArray();
		System.out.println("i6: " + chars[6]);
		System.out.println("c6: " + parent.charAt(6));
		
		
		String[] employee = {"EMP01", "Adam", "2500", "NewYork"};
		String result = "";
		for (String attrubute: employee) {
			result += "-" + attrubute;
		}
		result = String.join("-", employee);
		// result = String.join("-", "EMP01", "Adam", "2500", "NewYork");
		System.out.println("result 2: " + result);
		
		int[] e1 = {2, 3};
		int[] e2 = {2, 3, 4};
		System.out.println("sum: " + sum(e1));
		System.out.println("sum: " + sum(e2));
		System.out.println("sum: " + sum(1,1,36));
	}
	
	// varibles...
	// ... stands for array || set of 1 or n elements
	public static int sum(int... elements) {
		int result = 0;
		for (int element: elements) {
			result += element;
		}
		return result;
	}
}
