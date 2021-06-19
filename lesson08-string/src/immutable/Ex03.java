package immutable;

public class Ex03 {
	public static void main(String[] args) {
		String s1 = "Recycle V123iew";
		System.out.println("lenght " + s1.length());
		System.out.println("CharAt3: " + s1.charAt(3));
		
		// loop 
		for(int i=0; i<s1.length(); i++) {
			System.out.print(s1.charAt(i));
		}
		
		System.out.println();
	
		for(int i=0; i<s1.length(); i++) {
			System.out.print(Character.isDigit(s1.charAt(i)) ? s1.charAt(i): "");
		}
		
		s1 = s1.concat(" Layout");	// + operator || concatenate
		System.out.println("\ns1: " + s1);
		
		int indexY = s1.indexOf("y");
		int lastY = s1.lastIndexOf("y");
		System.out.println("first 'y' position:  " + indexY);
		System.out.println("last 'y' position:  " + lastY);
		
		System.out.println("sub: " + s1.substring(indexY, lastY +1));
	}
}
