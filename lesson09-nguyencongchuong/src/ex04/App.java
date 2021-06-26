package ex04;

public class App {
	public static void main(String[] args) {
		String text = "    Welcome   to JAVA10   class ";
		rSARTString(text); 
	}
	
	private static void rSARTString(String text) {
		String result = null;
		for(String texts : text.split("\\s+")) {

			StringBuilder builder = new StringBuilder(texts);
			System.out.print(builder.reverse() + " ");
		}
	}
}
