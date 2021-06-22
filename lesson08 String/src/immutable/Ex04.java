package immutable;

public class Ex04 {
	public static void main(String[] args) {
		String[] books = { "abSGK123", "abc234STK", "SGK223" };

		// Get classical book
		// startWith, endWith, contains
		for (String book : books) {
			if (book.contains("SGK") == true) {
				System.out.println(book);
			}
		}

		System.out.println("======================");

		String layout = "GridLayout";
		layout = layout.replace("Grid", "Border");
		System.out.println("layout : " + layout);
		
		String hobbies = "Football,,,    Volleyball,	 Badminton, Game";
		hobbies = hobbies.replaceAll("[,\\s]+", " ");
		System.out.println("hobbies : " + hobbies);
		
		String parent ="abcdefghklm";
	//	String sub = parent.subSequence(2, 7);// CharSequencce: la cha cua subSequence
		CharSequence sub = parent.subSequence(2, 7);// CharSequencce: la cha cua subSequence
		System.out.println("sub: " + sub);

		char[] chars = parent.toCharArray();
		System.out.println("i6: "+chars[6]);
		System.out.println("c6: "+parent.charAt(6));
		
	//	String.join(sub, books)
		String[] employee = {"EM01","Adam", "2500","Newyork"};
		String result ="";
		for(String attribute: employee) {
			result += "-" + attribute;
		}
		System.out.println("result1: " + result);
		
		result = String.join("-", "EM01","Adam", "2500","Newyork");
		System.out.println("result2: " + result);
		System.out.println(sum(111));
		
	}
	private static int sum(int... elements) {
		int result = 0;
		for (int element : elements) {
			result += element;
		}
		return result;
	}

}
