package ex03;

public class Ex03 {
	public static void main(String[] args) {
		String s = "xyz";
		permutation("", s);
	}
	
	private static void permutation(String pre, String str) {
	    int n = str.length();
	    if (n == 0) System.out.println(pre);
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(pre + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}
}
