package functional;
public class App {
   public static void main(String[] args) {
	// anonymous class
	   Condition c1 = new Condition() {
		
		@Override
		public boolean test(int a) {
			System.out.println("Test: " + a);
			return a % 2 == 0;
		}
	};
	c1.test(10);
	
	// class implement from interface
	Condition c11 = new EvenCondition();
	c11.test(10);
	
	Condition c2 = new Condition() {
		
		@Override
		public boolean test(int a) {
			return a % 2 != 0;
		}
	};
	c2.test(10);
	
	Condition c22 = new OddCondition();
	c22.test(10);
	
	
	// lambda expression =>> create an instance(object) for functional interface
	// lambda: 3parts: (danh sách tham số) -> {thân hàm}
	
	// anonymuous function = lambda expression
	Condition c3 =  a -> a % 5 == 0;
	System.out.println("b5: " + c3.test(10));
	
	Functional f1 = new Functional() {
		
		@Override
		public int func(int a, int b) {
			System.out.println("Sum: " );
			return a + b;
		}
	};
	System.out.println(f1.func(2, 3));
	
   Functional c5 = (a,b) -> a -b ;
   System.out.println("Sub: " + c5.func(10, 4));
   }
}
