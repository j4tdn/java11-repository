package data;

public class Ex06 {
      public static void main(String[] args) {
    	  Digit a = new Digit(10);
    	  Digit b = new Digit(20);
	      swap(a,b);
	      System.out.println("a: "+a);
	      System.out.println("b: "+b);
	      
	     // final int number = 100;
	      //number = 200;
	     
	      final  Digit d1 = new Digit(20);
	      d1.value = 30;
	      Digit d2 = new Digit(30);
	      System.out.println("sss"+d1.value);
      }
      private static void swap(Digit d1, Digit d2) {
    	  int tmp = d1.value;
    	  d1.value = d2.value;
    	  d2.value = tmp;
      }
}