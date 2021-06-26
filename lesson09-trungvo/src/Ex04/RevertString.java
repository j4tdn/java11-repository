package Ex04;

public class RevertString {
	public static void main(String[] args) {
		String s = "Welcome    to Java10    class";
		String reverse = replace(s);
		System.out.println(reverse);
		
		StringBuffer str = new StringBuffer(reverse);
		System.out.println(str.reverse());
		
		
	}
	
	private static String replace(String s) {
		String name = s.replaceAll("\\s+", " ");
		
		
		return name;
	}

}
	

