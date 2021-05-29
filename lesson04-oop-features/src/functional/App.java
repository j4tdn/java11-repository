package functional;

public class App {
	public static void main(String[] args) {
		Condition c1 = new Condition() {
			@Override
			public boolean test(int a) {
				System.out.println("IsEven: " + a);
				return a % 2 == 0;
			}
			
		};
		c1.test(10);
		Condition c11 = new EvenCondition();
		c11.test(10);
		
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
		
		// lambda expression => create an instance(object) for Functional Interface 
		// lambda: 3 parts: (danh sách tham số) -> {thân hàm}
		// Đang override lại hàm test mà không cần tạo class
		// anonymous function (Hàm k có tên) = lamda expression
		// Override hàm test, truyền vào biến a, trả về true, false
		// Nếu thân hàm có 1 dòng có thể viết như phía dưới
		Condition c3 = a -> a % 5 == 0;
		System.out.println("b5: " + c3.test(18));
		Functional f1 = new Functional() {
			@Override
			public int func(int a, int b) {
				System.out.println("SUM a b: ");
				return a + b;
			}
		};
		System.out.println(f1.func(1, 2));
		Functional f2 = (a, b) -> a - b;
		System.out.println("Sub: " + f2.func(10, 4));
	}
}

