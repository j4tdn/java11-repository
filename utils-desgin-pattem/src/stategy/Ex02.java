package stategy;

public class Ex02 {
	public static void main(String[] args) {
		int[] a =  {1,2,3,4,5,6,7,8,9};
		
		Condition c1 = num -> num % 2 == 0;
		Condition c2 = num -> num % 2 != 0;
		
		System.out.println("amount of even number : " + count(a, c1));
		System.out.println("amount of odd number : " + count(a, c2));
		System.out.println("amount of power of 3 : " + count(a, num -> num % 3 == 0));
	}
	
	
	// stategy pattern
	private static int count(int[] a, Condition conditon) {
		int count = 0;
		for(int i = 0; i < a.length; i ++) {
				if(conditon.test(a[i])) {
					count ++;
				}
		}
		return count;
	}
}
