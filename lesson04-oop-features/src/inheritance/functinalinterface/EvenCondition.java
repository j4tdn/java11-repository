package inheritance.functinalinterface;

public class EvenCondition implements Predicate{

	@Override
	public boolean test(int num) {
		return num%2==0;
	}

}
