package ex03;

public class Ex03 {
public static void main(String[] args) {
	String s = "xyz";
	permutation(s);
	
}
public static void permutation(String s) { 
    permutation("", s); 
}

private static void permutation(String pf, String s) {
    int n = s.length();
    if (n == 0) {
    	System.out.println(pf);
    }else {
        for (int i = 0; i < n; i++)
            permutation(pf + s.charAt(i), s.substring(0, i) + s.substring(i+1, n));
    }
}
}
