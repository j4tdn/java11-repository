package inheritance.functionalinterface;

public class EvenCondition implements Condition {
	@Override
	public boolean test(int num) {
		return num % 2 == 0;
	}
}
