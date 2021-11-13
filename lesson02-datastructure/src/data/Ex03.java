package data;

public class Ex03 {
	public static void main(String[] args) {
		
		int a=20;
		a=30;
		
		Integer age=20;
		System.out.println("Hashcode age 1:" +System.identityHashCode(age));
		
		age =30;
		System.out.println("Hashcode age 2:" +System.identityHashCode(age));
		
		
		System.out.println("age1:"+ age);
		increase(age);
		System.out.println("age1:"+ age);


	}
	
	private static void increase(Integer input)
	{
		input+=1;
	}

}