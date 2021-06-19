package immutable;

public class Ex03 {
	public static void main(String[] args) {
		String s1 = "Recycle View";
		
		System.out.println("length: " + s1.length());
		System.out.println("charAt3: " + s1.charAt(3));
		
		for(int i=0;i < s1.length();i++) {
			char tmp = s1.charAt(i);
			if(Character.isDigit(tmp)) {
				System.out.println(tmp);
			}
		}
		
		s1 = s1 + "- Layout";
		System.out.println("s1: " + s1);
		
		int indexY = s1.indexOf("y");
		int lastY = s1.lastIndexOf("y");
		
		System.out.println();
		System.out.println();
	}

}
