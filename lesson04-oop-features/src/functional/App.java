package functional;

public class App {
	public static void main(String[] args) {
		// anonymous class
		Condition c1 = new Condition() {

			@Override
			public boolean test(int a) {
				System.out.println("Is Even: " + a);
				return a % 2 == 0;
			}
		};

		c1.test(10);

		// class implement from interface
		Condition c11 = new EvenCondition();
		c11.test(10);

		// anonymous class
		Condition c2 = new Condition() {

			@Override
			public boolean test(int a) {
				System.out.println("Is Odd: " + a);
				return a % 2 != 0;
			}
		};

		c2.test(10);

		// class implement from interface
		Condition c22 = new OddCondition();
		c22.test(10);

		// lambda expression => create an instance(object) for Functional Interface
		// Lambda: 3 parts: (danh sach tham so) -> {than ham}
		// anonymous function = lambda expression
		Condition c3 = a ->  a % 5 == 0;
		System.out.println("b5: " + c3.test(20));
		
		Functional f1 = new Functional() {
			
			@Override
			public int func(int a, int b) {
				System.out.println("SUM a b");
				return a + b;
			}
		};
		System.out.println(f1.func(1, 2));
		
		Functional f2 = (a, b) -> a - b;
			System.out.println("sub: " + f2.func(10, 4));
	}
}
