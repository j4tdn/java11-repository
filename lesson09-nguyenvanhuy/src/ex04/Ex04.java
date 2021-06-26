package ex04;

public class Ex04 {
	public static void main(String[] args) {
		String s = "Welcome   to JAVA10   class";
		s = s.replaceAll("\\s+", " ");
		System.out.println("s: " + s);
		
		StringBuilder srv = new StringBuilder();
		srv.append(s);
		srv.reverse();
		System.out.println(srv);
	}
}
