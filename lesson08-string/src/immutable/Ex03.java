package immutable;

public class Ex03 {
	public static void main(String[] args) {
		int[] a = {1,2,3};
		for(int i = 0; i < a.length; i++) {
			System.out.println("xx: " + a[i]);
		}
		String s1 = "Re2cy5cle Vi7ew";
		
		System.out.println("length: " + s1.length());
		System.out.println("charAt3: " + s1.charAt(3));
		
		for(int i = 0; i < s1.length(); i++) {
			char tmp = s1.charAt(i);
			if(Character.isDigit(tmp)) {
				System.out.println(tmp);
			}
		}
		s1 = s1.concat(" - Layout");
		System.out.println("s1: " + s1);
		
		int indexY = s1.indexOf("y");
		int lastY = s1.lastIndexOf("y");
		
		System.out.println("first 'y' position: " + s1.indexOf("y"));
		System.out.println("last 'y' position: " + s1.lastIndexOf("y"));
		
		System.out.println("sub: " + s1.substring(indexY, lastY+1));
	}

}
