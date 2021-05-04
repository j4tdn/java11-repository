package operator;

public class Ex01 {
  public static void main(String[] args) {
	//isEven
	int n = 20;
	boolean isEven = isEven(n);
	
	// if (isEven) => if (isEven == true)
	// if (!isEven) => if (isEven == false
	
	if (isEven == true) {
		System.out.println(n + "is even number");
	} else {
		
	}
	
}

  private static boolean isEven(int input) {
	return input % 2 == 0;
}
}
