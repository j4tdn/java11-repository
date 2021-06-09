package inheritance.functionalinterface;

public class OddCondition implements Condition {
	@Override
	public boolean test(int num) {
		return num % 2 != 0;
	}
}
