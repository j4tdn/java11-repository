package immutable;

public class Ex04 {
	public static void main(String[] args) {
		String[] books = {"SGK123", "STK234", "SGK223"};
		
		//Get classical book
		//startWith, endWith, contains
		for(String book: books) {
			if(book.startsWith("SGK")) {
				System.out.println(book);
			}
		}
		System.out.println("==============");
		
		String layout = "GridLayout";
		layout = layout.replace("Grid", "Border");
		System.out.println("layout: " + layout);
		
		String hobbies = "Football    Volleyball        Badminton, Game";
		hobbies = hobbies.replaceAll("[,\\s]+", " ");
		System.out.println(hobbies);
		
		String parent = "wojisjdiaa";
		String sub = parent.substring(2, 7);
		System.out.println("sub: " + sub);
		
		char[] chars = parent.toCharArray();
		System.out.println("i6: " + chars[6]);
		System.out.println("c6: " + parent.charAt(6));
		
		String[] employees = {"emp1", "emp2", "emp3"};
		String result = "";
		for(String attribute: employees) {
			result += "-" + attribute;
			
		}
		System.out.println("result1: " + result);
		
	    result = String.join("-", "emp1", "emp2", "emp3");
	    System.out.println("result2: " + result);
	    
	    int[] e1 = {2,3};
	    int[] e2 = {2,3,4};
	    System.out.println("sum: " + sum(e1));
	    System.out.println("sum: " + sum(e2));
	    System.out.println("sum: " + sum(1,1,36));
	    
		
	    
	}
	
	//variables ...
	// ... stands for array || set of or n elements
	
	public static int sum(int... elements) {
		int result = 0;
		for (int element: elements) {
			result += element;
		}
		return result;
	}

}
