package immutable;

public class Ex04 {
	public static void main(String[] args) {
		String[] books = {"SGK123", "STK224", "SGK223"};
		
		// Get classical book
		for (String book : books) {
			if (book.startsWith("SGK")) { // endsWith()
				System.out.println(book);
			}
		}
		
		String layout = "GridLayout";
		layout = layout.replace("Grid", "Border");
		System.out.println(layout);
		
		String hobbies = "Football,  ,    Volleyball     Badminton";
		hobbies = hobbies.replaceAll("[,\\s]+", " ");
		System.out.println(hobbies);
		
		String parent = "afnamnfkfdsvdf";
		String sub = parent.substring(2, 7);
		System.out.println(sub);
		
		char[] chars = parent.toCharArray();
		System.out.println(chars[6]);
		System.out.println(parent.charAt(6));
		
		String[] employee = {"emp01", "asf", "dsg"};
		String result = "";
		
		for(String attribute : employee) {
			result += attribute + "-";
		}
		
		result = String.join("-", employee);
		
		
	}
	
	public static int sum(int...elements) {
		int result = 0;
		
		for (int element:elements) {
			result += element;
		}
		return result;
	}
}

