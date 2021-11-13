package data;


public class Ex06 {
	
	public static void main(String[] args) {
		Integer a= 10;
		Integer oa = new Integer(20);
		
		Digit d1 = new Digit(10);
		Digit d2 = new Digit(20);
		
		swap(d1,d2);
		
		System.out.println(d1);
		System.out.println(d2);
}
	private static void swap(Digit a, Digit b)
	{
		int tmp=a.value;
		a.value=b.value;
		b.value=tmp;
	}
}