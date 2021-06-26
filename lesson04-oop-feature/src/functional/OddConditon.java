package functional;

public class OddConditon implements Condition {
	@Override
	public boolean test(int a) {
		System.out.println("Is Odd: " + a);
		return a % 2 != 0;
	}
}