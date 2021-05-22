package ex03;

public class Ex03 {
	public static void main(String[] args) {
		System.out.println(IsPowOf(2, 8));
	}

	private static boolean IsPowOf(int a, int b) {
		int i = 0;
		while (true) {
		if (a > b) {
		  if (Math.pow(b, i) == a) {
			return true;
			} else if (Math.pow(b, i) > a) {
			return false;
			}
		}
		if (b > a) {
		   if (Math.pow(a, i) == b) {
				return true;
			} else if (Math.pow(a, i) > b) {
				return false;
			}
		}
		i++;
	}
}
}
 
  

