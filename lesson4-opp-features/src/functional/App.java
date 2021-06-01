package functional;

public class App {
	public static void main(String[] args) {
		//anonymous class: lop an danh
		Condition c1 = new Condition() {
			
			@Override
			public boolean test(int a) {
				System.out.println("test: " + a);
				return a % 2 ==0;
			}
		};
		c1.test(10);
		//class implement from interface
		Condition c11 = new EvenCondition();
		c11.test(10);
		
		Condition c22 = new OddCondition();
		c22.test(10);
		
Condition c2 = new Condition() {
			
			@Override
			public boolean test(int a) {
				System.out.println("Odd: " + a);
				return a % 2 !=0;
			}
		};
		c2.test(10);
		
		
		//lambda expression => create an instance(object) for 
		// lambda: 3 parts (danh sach tham so) -> {than ham}
		//anonymous function : lambda expresstion
		Condition c3 = (int a) -> {
			System.out.println("Epx test b5.....");
			return a%5 ==0;
		};
		c3.test(8);
		
		Condition c33 = a -> a%5 == 0;
		System.out.println("b5: " + c33.test(18));
		
		Functional f1 = new Functional() {
			
			@Override
			public int fuc(int a, int b) {
				System.out.println("Sum A + B = ");
				return a+b;
			}
		};
		System.out.println(f1.fuc(5, 6));
		
		Functional f2 = (a,b) -> a-b;
		System.out.println("Sub: " + f2.fuc(10, 4));
	}
}
