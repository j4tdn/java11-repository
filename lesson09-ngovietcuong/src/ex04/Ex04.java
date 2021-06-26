package ex04;

public class Ex04 {
	public static void main(String[] args) {
		String s = "Welcome    to JAVA10    class ";
		revert(s);
	   
	}

	public static void revert(String s) {
		s = s.replaceAll("[\\s]+", " ");
		System.out.println("Chuoi truoc khi dao: " + s);
		System.out.print("Chuoi sau khi dao: ");
		String[] line = s.split(" ");
		for(String st:line) {
	      String reverse = new StringBuffer(st).reverse().toString();
	      System.out.print(reverse + " ");
	     }
		
	}
}
