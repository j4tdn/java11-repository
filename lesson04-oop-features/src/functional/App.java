package functional;

public class App {
	public static void main(String[] args) {
		
		// anonymous class
		Condition c1 = new Condition() {		
			@Override
			public boolean test(int a) {
				System.out.println("Test :" + a);
				return a % 2 == 0;
			}
		};	
		c1.test(10);
		
		Condition c2 = new EvenCondition();
		c2.test(10);
		
		Condition c3 = new OddCondition();
		c3.test(7);
		
		// lambda expression => create an instance(object) for functional interface
		// Lambda 3 parts : (danh sách tham số ) -> (thân hàm)
		// anonymous function = lambda expression 
		Condition c4 = (int a) -> {
			System.out.println("Lambda express ....... " + a);
			return a % 2 == 0;
		};
		c4.test(5);
		
		Condition c5 =  a -> a % 2 == 0;
		System.out.println( "Test : " +c5.test(10));
		
		Functional f1 = (a,b) -> a + b;
		System.out.println("sub : " + f1.func(5, 2));
	}
}
