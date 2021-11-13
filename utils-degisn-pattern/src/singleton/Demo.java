package singleton;

public class Demo {
	public static void main(String[] args) {
		DateTimeHelper d1 = DateTimeHelper.getInstance();
		DateTimeHelper d2 = DateTimeHelper.getInstance();
		
		Hash(d1);
		Hash(d2);
	}
	
	private static void Hash(DateTimeHelper input) {
		System.out.println(System.identityHashCode(input));
	}
}
