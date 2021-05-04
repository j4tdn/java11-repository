package operator;

public class Ex01 {
	public static void main(String[] args) {
		if(isEven(10)) {
			System.out.println("ok");
		}
		else {
			System.out.println("not ok");
		}
		
	}
     static boolean isEven(int input) {
		return input % 2 == 0;
	}
	

}
