package functional;

public class EvenCondition implements Condition {

	@Override
	public boolean test(int a) {
		System.out.println("EvenCondition: " + a);
		return a % 2 == 0;
	}
	

}