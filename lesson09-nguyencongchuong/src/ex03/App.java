package ex03;

public class App {
	public static void main(String[] args) {
		permutation("xyz");
	}
	public static void permutation(String s) { 
	    permutation("", s); 
	}

	private static void permutation(String p, String s) {
	    int n = s.length();
	    if (n == 0) System.out.println(p);
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(p + s.charAt(i), s.substring(0, i) + s.substring(i+1, n));
	    }
	}
}
