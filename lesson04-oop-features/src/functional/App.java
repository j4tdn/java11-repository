package functional;

public class App {
	public static void main(String[] args) {
		// anonymous class
		Condition c1 = new Condition() {

			@Override
			public boolean test(int a) {
				System.out.println("Test xyz: " + a);
				return a % 2 == 0;
			}
		};
		
		// class implement from interface
		Condition c11 = new EvenConditon();
		c11.test(10);

		c1.test(10);

		Condition c2 = new Condition() {

			@Override
			public boolean test(int a) {
				System.out.println("Is Odd: " + a);
				return a % 2 != 0;
			}
		};

		c2.test(10);
		
		Condition c22 = new OddCondition();
		c22.test(10);
		
		// Lambda expression => create an instance(object) for Functional Interface\
		// Lambda: 3 parts: (danh sách tham số) -> { Thân hàm }
		Condition c3 = a ->  a % 2 == 0;
     	System.out.println("b5: " + c3.test(18));
		
		Functional f1 = new Functional() {
			
			@Override
			public int func(int a, int b) {
				System.out.println("SUM a b");
				return a + b;
			}
		};
		System.out.println(f1.func(1, 2));
		
		Functional f2 = (a,b) ->  a - b;
		System.out.println("sub: " + f2.func(10, 4));
		
	}
}
