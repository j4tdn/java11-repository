package Ex04;

public class Ex04 {
	public static void main(String[] args) {
		String s = "Welcome to JAVA10 class";
		System.out.println(s);
	
		reverse(s);

	}
	public static void reverse(String s) {
		String[] strings = s.split(" ");
		
		for(String s1 : strings) {
		      String s2 = new StringBuffer(s1).reverse().toString();
		      System.out.print(s2 + " ");
		     }
		
		
	}

}
