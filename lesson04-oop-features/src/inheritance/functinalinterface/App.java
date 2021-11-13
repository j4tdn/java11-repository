package inheritance.functinalinterface;

public class App {
	public static void main(String[] args) {
		int[] digits = { 1, 4, 8, 12, 25, 60 };
		System.out.println("count even: "+count(digits,num->num%2==0));
		System.out.println("count ood: "+count(digits,num->num%2!=0));
		System.out.println("count d3: "+count(digits,num->num%3==0));
		System.out.println("count d5: "+count(digits,num->num%5==0));
	}

	private static int count(int[] digits, Predicate con) {
		int count = 0;
		for (int digit : digits) {
			if (con.test(digit)) {
				count++;
			}
		}
		return count;
	}
}
