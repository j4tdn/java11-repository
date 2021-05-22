package ex01;

public class Ex01 {
	public static void main(String[] args) {
		int[] a = {3,15,21,0,15,17,21};
		for(int item : getUniqueNumbers(a)) {
			System.out.print(item + ", ");
		}
	}

	public static int[] getUniqueNumbers(int[] A) {
		int[] B = new int[10];
		int dem = 0;
		for(int item : A ) {
			int count = 0;
			for(int items : A) {
				if(item == items) count ++;
			}
			if(count < 2 ) {
				B[dem] = item;
				dem ++;
			}
		}
		return B;
	}
}
