package ex04;

public class Ex04 {
	public static void main(String[] args) {
		String input = "Welcom       to JAVA10  class";
		String result = getReverse(input);
		System.out.println(result);
		
	}
	
	public static String reverse(String input){
	    char[] in = input.toCharArray();
		int begin = 0;
	    int end= in.length - 1;
	    char temp;
	    while(end>begin){
	        temp = in[begin];
	        in[begin]=in[end];
	        in[end] = temp;
	        end--;
	        begin++;
	    }
	    return new String(in);
	}
	
	private static String getReverse(String input) {
		String result = input.replaceAll("\\s+", " "); 
		String[] str = result.split(" ");
		StringBuilder a = new StringBuilder();
		for(int i = 0; i < str.length; i++) {
			a.append(reverse(str[i]) + " ");
		}
		
		return a.toString();
	}
	
}
