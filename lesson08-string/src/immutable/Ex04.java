package immutable;

public class Ex04 {
	public static void main(String[] args) {
		String[] books = {"SGK123", "STK234","SGK123"};
		//Get classical book
		
		for(String book: books) {
			if(book.startsWith("SGK")) { //kiem tra co bat dau bang SGK hay khong
				System.out.println(book); //book.endsWith("123");
										//book.contains("SGK");
				
			}
		}
		System.out.println("============================");
		String layout = "GridLayout";
		layout = layout.replace("Grid", "Border"); //thay the
		System.out.println("layout: " +layout);
		
		
		String hobbies = "Football,,,,, 	Volleyball		 	Badminton   Game" ; 
		//loai bo khoang trang thua
		hobbies = hobbies.replaceAll("\\s+", " "); //   \\s{1,}
		//thay the 1 tap ki tu 		("[,\\s]+", " ");
		System.out.println("hobbies: " + hobbies);
		
		String parent = "abcdefghjkl";
		CharSequence sub = parent.substring(2, 7);
		System.out.println("sub: " + sub);
		
		char[] chars = parent.toCharArray();
		System.out.println("i6: "+ chars[6]);
		System.out.println("c6: " + parent.charAt(6));
		
		//String.join(sub, books)
		
		System.out.println("=========================");
		String [] employee = {"EM01", "Adam","2500", "NewYork"};
		String result ="";
		for(String attribute : employee) {
			result+= "-" + attribute;
		}
		System.out.println("result1: " + result);
		
		result= String.join("-", employee);
		System.out.println("result2: " + result);
		int [] e1 = {1,2,3};
		int [] e2 = {1,2,3,454};
		System.out.println("sum: " + sum(e1));
		System.out.println("sum: " + sum(e2));
		System.out.println("sum: " + sum(1,1,40));
	}
	//...stands for array || set of 1 or n elements
	public static int sum(int...elements) {
		int result =0;
		
		for (int element: elements) {
			result += element;
		}
		return result;
	}
}