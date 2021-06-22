package immutable;

public class Ex04 {
	public static void main(String[] args) {
		String[] books = {"SGK123", "STK234", "SGK223"};
		
		// Get classical book
		for(String book: books) {
			if(book.contains("SGK")) {
				System.out.println(book);
			}
		}
		System.out.println("=========================");
		
		String layout = "GridLayout";
		layout = layout.replace("Grid", "Border");
		System.out.println("layout: " + layout);
		
		// abz123@nn.com
		String hobbies = " Football,,,       Basketball";
		hobbies = hobbies.replaceAll("[,\\s]+", " ");
		System.out.println("hobies: " + hobbies);
		
		String parent = "abcdefghikl";
		String sub = parent.substring(2, 10);
		System.out.println("sub: " + sub);
		
		char[] chars = parent.toCharArray();
		System.out.println("i6: " + chars[6]);
		System.out.println("c6: " + parent.charAt(6));
		
		String[] employee = {"EM01", "Adam", "2500", "Hoa"};
		String result = "";
		for(String attribute: employee) {
			System.out.println();
		}
		String.join("-", employee);
		System.out.println(String.join("-", employee));
		
		int[] e1 = {2, 3};
		int[] e2 = {2,3,4};
		System.out.println("sum: " + sum(e1));
		System.out.println("sum: " + sum(e2));
		System.out.println("sum: " + sum(1,3,4,5));
		
	}
	
	// variable ...
	// ... stands for array || set of 1 of n elements
	public static int sum(int... elements) {
		int result = 0;
		
		for (int element: elements) {
			result += element;
		}
		return result;
	}
}
