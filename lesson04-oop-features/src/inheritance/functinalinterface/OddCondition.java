package inheritance.functinalinterface;

public class OddCondition implements Predicate {

	@Override
	public boolean test(int num) {
	return num%3==0;
	}
	
}
