package immutable;

public class Ex03 {
	public static void main(String[] args) {
		int[] a = {1, 2, 3};
		for (int i = 0; i < a.length; i++) {
			System.out.println("xx: " + a[i]);
		}
		String s1 = "RecycleView";
		System.out.println("length: " + s1.length());
		System.out.println("charAt3: " + s1.charAt(3));
		
		for (int i = 0; i < s1.length(); i++) {
			char tmp = s1.charAt(i);
			if (Character.isDigit(tmp)) {
				System.out.println(s1.charAt(i));
			}
		}
		// s1 = s1 + "- Layout"; // + - Save in constant pool
		s1 = s1.concat(" - Layout"); // concatenate -  Save in constant pool 
		System.out.println("s1: " + s1);
		
		int indexY = s1.indexOf("y");
		int lastY = s1.lastIndexOf("y");
		System.out.println("first 'y' position: " + indexY);
		System.out.println("last 'y' position: " + lastY);
		System.out.println("sub: " + s1.substring(indexY, lastY));
	}
}
