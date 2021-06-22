package immutable;

public class Ex04 {
	public static void main(String[] args) {
		String [] books = {"SGK123","STK234", "SGK223"};
		
		//Get classical book
		for(String book: books) {
			if(book.startsWith("STK")) {
				System.out.println(book);
			}
		}
		
		String layout = "GridLayout";
		layout = layout.replace("Grid", "Layout");
		System.out.println("layout: " + layout);
		
		String hobbies = "Football, Volleyball, Badminton, Game";
		hobbies = hobbies .replaceAll("[,\\s]+", " ");
		System.out.println("hobbies: "+ hobbies);
		
		String parent = "abcdefghklm";
		CharSequence sub = parent.substring(2, 7);
		System.out.println("sub: " +sub);
		
		char[] chars = parent.toCharArray();
		System.out.println("i6:" + chars[6]);
		System.out.println("c: " +parent.charAt(6));
		
		String[] employee  = {"EMP01", "Adam", "2500", "Newyork"};
		String result = "";
		for(String attribute: employee) {
			result += "-" + employee;
		}
		System.out.println("result1: " + result);
		
		result= String.join("-", employee);
		System.out.println("result2: " + result);
		int [] e1 = {1,2,3};
		int [] e2 = {1,2,3,454};
		System.out.println("sum: " + sum(e1));
		System.out.println("sum: " + sum(e2));
		
		}
	
	public static int sum(int... elements) {
		int result = 0;
		
		for(int element: elements) {
			result += element;
			
		}
		return result;
	}

}
