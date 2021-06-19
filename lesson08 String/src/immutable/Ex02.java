package immutable;

import util.jvmUtil;

public class Ex02 {
	public static void main(String[] args) {
		// Difference between String Literal and Object
		
		String s1 = "literal";
		String s2 = "literal";// only create one on heap
		String s3 = "lite"+"ral";// only create one on heap
		jvmUtil.hash("s1", s1);
		jvmUtil.hash("s2", s2);
		jvmUtil.hash("s3", s3);
		// => constainbool cua HEAP
		System.out.println("======================================");
		
		String o1 = new String("welcome");
		String o2 = new String("welcome");// tao 2 o nho tren heap
		String o3 = new String("literal");
		jvmUtil.hash("o1", o1);
		jvmUtil.hash("o2", o2);
		jvmUtil.hash("o3", o3);
		
		// so sanh :   ==  => ss tren STACK - variable
		//  equals(default - STACK - variable, being override - value)
		// funtionnal interface chi co 1 phuong thuc truong  tuong
		
		System.out.println("====================");
		System.out.println("s1==s2 " + (s1==s2));
		System.out.println("s1==s3 " + (s1==s3));
		System.out.println("s1==o1 " + (s1==o1));
		System.out.println("o1==o2 " + (o1==o2));
		System.out.println("o1==o3 " + (o1==o3));
		System.out.println("o2==o3 " + (o2==o3));
		System.out.println("===========================");
		System.out.println("s1 eq s2 " + (s1.equals(s2))); 
		System.out.println("s1 eq s3 " + (s1.equals(s3))); 
		System.out.println("s1 eq o1 " + (s1.equals(o1))); 
		System.out.println("o1 eq o2 " + (o1.equals(o2)));
		System.out.println("o1 eq o3 " + (o1.equals(o3)));
		System.out.println("o2 eq o3 " + (o2.equals(o3)));
		System.out.println("==============================");
		System.out.println(" s1 cp s2 "+ (s1.compareTo(s2)));// = nhau = 0 cp : gia tri phan biet hoa thuong
		System.out.println(" s1 cp o2 "+ (s1.compareTo(o2)));// nho be hon nguoc lai

		
	}
}
