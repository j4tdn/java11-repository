package functional;

public class App {
	public static void main(String[] args) {
		// anonymous class
		Condition c1 = new Condition() {

			@Override
			public boolean test(int a) {
				System.out.println("Tets: " + a);
				return a % 2 == 0;
			}
		};
		
		c1.test(10);
                Condition c11 = new EvenCondition();
                c11.test(10);
                /////////////////////////
                Condition c2 = new Condition() {
                    @Override
                    public boolean test(int a) {
                        System.out.println("is Odd: " +a);
                                return a % 2 != 0;
                    }
                };
                Condition c22 = new Oddcondition();
                c22.test(10);
                 //lambda expression >> create an instance(object) for Functional Interface
                 //lambda: 3 parts: (danh sach tham so) -> ( than ham)
                 // anonymous fuction = lamda expression
                 Condition c3 = (int a) ->{
                     System.out.println("Epx test ...");
                     return a%2==0;
                 };
                 c3.test(8);
                 Functional f1 = new Functional() {
                    @Override
                    public int func(int a, int b) {
                        System.out.println("SUM a b: ");
                        return a+b;
                    }
                 };
                 System.out.println(f1.func(1, 2));
                 Functional f2 =(a,b) -> a-b;
                 System.out.println("sub: " + f2.func(10, 4));
                 
                 
	}
}
