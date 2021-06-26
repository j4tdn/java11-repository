package ex03;

public class Permutation {
	public static void main(String args[]) {
		String s = "xyz";
		String blank = " ";

		System.out.print("input: " + s);

		System.out.print("\noutput:");
		permutation(s, blank);
	}

	static void permutation(String s, String blank) {
		 if (s.length() == 0)
		    {
		        System.out.print(blank + " ");
		        return;
		    }
		 
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			String leftString = s.substring(0, i);
			String rightString = s.substring(i + 1);
			permutation(leftString + rightString, blank + ch);
		}
	}

}
