package exercise;

public class Ex05 {
	public static void main(String[] args) {
		System.out.println(changeDecimalToBinary(123));
	}
	private static int changeDecimalToBinary(int n) {
		int rem, sum = 0, i = 1;
		do
	    {
	        rem = n % 2;
	        sum = sum + (i * rem);
	        n=n/2;
	        i=i*10;
	    }while(n>0);
		return sum;
	}
}
