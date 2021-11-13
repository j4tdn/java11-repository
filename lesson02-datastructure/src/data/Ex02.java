package data;

public class Ex02 {
	public static void main(String[] args) {
		int age =20;
		int year =2000;
		
		Integer a =20;
		Integer b=60;
		swap(a,b);
		System.out.println(a);
		
//		age = year;
//		year = age;
//		increase(age);
//		swap(age, year);
//		
//		System.out.println("Age:" +age);
//		System.out.println("year:" +year);
	}
	private static void increase(int age)
	{
		age = age+1;
	}
	private static void swap(int a, int b)
	{
//		int tmp = a;
//		a=b;
//		b=tmp;
		
		a=a+b;//20+40
		b=a-b; 
		a=a-b;
	}

}