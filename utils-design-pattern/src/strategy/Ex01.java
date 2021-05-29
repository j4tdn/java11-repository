package strategy;

public class Ex01 {
public static void main(String[] args) {
	int a =5;
	int b = 10;
	
	System.out.println("sum: " + sum(a, b));
	System.out.println("sub: " + sub(a, b));
	Functional functional = (x,y) -> x + y;
	System.out.println("result: " + calculate(a,b , functional));
  }  

    private static int calculate(int a,int b, Functional f) {
	   return f.func(a, b);
  }
    
    private static int sum(int a,int b) {
    	return a+b;
    }
    
    private static int sub(int a, int b) {
    	return a-b;
    }
}
