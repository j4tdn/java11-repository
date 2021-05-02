package operator;

public class Ex01 {
	public static void main(String[] args) {
		int n = 11;
		boolean isEven= isEven(n);
		if(!isEven) {
			System.out.println(n + " is odd number");
		}else {
			System.out.println(n + " is even number");
		}
		System.out.println(n + " is " + (isEven ? "even": "ood") + " number");
		int i=1; 
	    i += ++i + i++;
		System.out.println(i);
	}

	private static boolean isEven(int input) {
		return input%2==0;
	}	
}
