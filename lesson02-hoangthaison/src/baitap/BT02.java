package baitap;



public class BT02 {
	public static void main(String[] args) {
		
		long x = 4;
		long y = 7;
	    long z = 12;
		long k = 18;
		
		long sum = GiaiThua(x)+GiaiThua(y)+GiaiThua(z)+GiaiThua(k);
		System.out.println("4!+7!+12!+18! = " +sum );
	}
	private static  long GiaiThua(long x) {
		 if( x > 	0) {
			 return x*GiaiThua(x-1);
		 }else {
			 return 1;
		 }
	}

}
