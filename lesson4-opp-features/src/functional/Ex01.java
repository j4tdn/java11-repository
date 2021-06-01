package functional;

public class Ex01 {
	public static void main(String[] args) {
		int a = 10;
		int b = 5;
		
		System.out.println("sum: " + sum(a,b) );
		
		//input: a,b
		//condition ?
		//result a ? b
		Functional functional = (x,y) -> x-y;
		System.out.println("result: " + calculation(a,b,functional));
		
		
	}
	//stategy pattern
	private static int calculation(int a, int b, Functional f) {
		return f.fuc(a, b);
	} 
	
	public static int sum(int a, int b) {
		return a + b;
	}
	
	
}
