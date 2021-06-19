package immutable;

public class Ex03 {
	public static void main(String[] args) {
		String s1 = "Recy22le Vie44w";

		System.out.println("length : " + s1.length());
		System.out.println("charAt3 : " + s1.charAt(3));

		// loop
		for (int i = 0; i < s1.length(); i++) {
			if (Character.isDigit(s1.charAt(i)))
				System.out.println(s1.charAt(i));
		}
		
		s1 = s1.concat(" - Layout"); // s1 = s1 + " - Layout";
		System.out.println("s1 : " + s1);
		
		int indexY = s1.indexOf("y");
		int lastY = s1.lastIndexOf("y");
		
		System.out.println("first 'y' position : " + indexY);
		System.out.println("last 'y' position : " + lastY);
		
		System.out.println("sub : " + s1.substring(indexY, lastY + 1));
	}
}
