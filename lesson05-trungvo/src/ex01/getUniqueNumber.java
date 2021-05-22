package ex01;

public class getUniqueNumber {
	public static void main(String[] args) {
		int[] a = { 3, 15, 21, 0, 15, 17, 21 };
		
		int[] result = getUniqueNumbers(a);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]+" ");
		}
		
		
	}
	private static int[] getUniqueNumbers(int[] a) {
		int[] b = new int[a.length];
		int count=0;
		for (int i = 0; i < a.length; i++) {
			if (countElement(a, a[i]) == 1) {
				b[count++]=a[i];
			}
		}
		int[] result = new int[count];
	
		for (int i = 0; i < count; i++) {
			result[i]=b[i];
		}
		sortArray(result);
		return result;
	}
	private static void sortArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if(a[j]>a[i]) {
					int temp = a[i];
					a[i] = a[j];
					a[j]= temp;
				}
			}
		}
	}

	private static int countElement(int[] a, int n) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (n == a[i]) {
				count++;
			}
		}
		return count;
	}
}