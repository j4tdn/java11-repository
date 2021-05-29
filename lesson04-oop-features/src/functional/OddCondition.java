package functional;

public class OddCondition implements Condition {
	@Override
	public boolean test(int a) {
		System.out.println("Odd condition: " +a);
		return a % 2 != 0;
	}
}
