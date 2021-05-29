package functional;

public class App {
	public static void main(String[] args) {

		Condition c1 = new Condition() {

			@Override
			public boolean test(int a) {
				System.out.println("Is even: " + a);
				return a % 2 == 0;
			}
		};

		// class implement from interface
		Condition c11 = new EvenCondition();
		c11.test(7);

		Condition c2 = new OddCondition();
		c2.test(7);

		c1.test(10);

		// lambda expression => create an instance(object) for Functional Interface
		// Lambda: 3 parts: (list parameters)-> (function body)

		// anonymous function = lambda express
		Condition c3 = (a) -> a % 2 == 0;

		System.out.println("Even number? " + c3.test(4));

		Functional f1 = (int a, int b) -> {
			return a + b;
		};
		System.out.println("sum: " + f1.func(5, 6));

		Functional f2 = (int a, int b) -> a - b;
		System.out.println("sub: " + f2.func(5, 6));
	}

}
