package inheritance.functinalinterface;

public class Demo {
	public static void main(String[] args) {
		System.out.println("sum: " +calculate(10, 20, (a,b)->a+b));
	}
	
	private static int calculate(int a, int b, Manipulation mal)
	{
		return mal.perform(a, b);
	}
	private static int sum(int a, int b)
	{
		return a+b;
	}
	private static int sub(int a, int b)
	{
		return a-b;
	}
	private static int devide(int a, int b)
	{
		return a*b;
	}
	private static int multiple(int a, int b)
	{
		return a/b;
	}
}
