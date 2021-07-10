package immutable;

public class Ex04 {
	public static void main(String[] args) {
		String[] books = {"SGK123", "STK23", "SGK223"};
		
		// Get classical book
		// startWith, endWith, contains
		for(String book : books) {
			if(book.contains("SGK")) {
				System.out.println(book);
			}
		}

		String layout = "GridLayout";
		layout = layout.replace("Grid", "Border");
		System.out.println(layout);
		
		
		// email: abc1234@gmail.com
		// [a-z01-9]+@[a-z01-9][a-z]+
		String hobbies = "Football,,,      Volleyball,,   Badminton, Game";
		hobbies = hobbies.replaceAll("[,\\s]+", " ");
		System.out.println(hobbies);
		
		String parent = "abcdefghklm";
		CharSequence sub = parent.subSequence(2, 7);
		System.out.println("sub: " + sub);
		
		String[] employee = {"EMP01", "Adam", "2500", "Newyork"};
		String result = "";
		for(String att: employee) {
			result += att + "-";
		}
		System.out.println("result: " + result);
		
		result = String.join("-", employee);
		System.out.println("result join: " + result);
		char[] chars = parent.toCharArray();
		System.out.println("i6: " + chars[6]);
		System.out.println("sum: " + sum(1,3,4));
		
	}
	
	// variables ...
	// ... stands for array || set of 1 or n elements
	
	public static int sum(int... elements) {
		int result = 0;
		for(int element: elements) {
			result += element;
		}
		return result;
	}
}
