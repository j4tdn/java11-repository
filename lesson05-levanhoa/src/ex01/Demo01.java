package ex01;

public class Demo01 {
	public static void main(String[] args) {
		int n = 12;
		int[] array = new int[] {6, 54, 8, 21, 8, 7, 98, 4, 4, 7, 3, 1};
		int count = 0;
		for (int i = 0; i < n; i++) {
			boolean check = checkUnique(array, n, array[i]);
			if (check) {
				count++;
			}
		}
		System.out.println("so phan tu suat hien mot lan: " + count);
		int[] s = new int[count];
		for (int j = 0; j < n; j++) {
			int k = 0;
			boolean check = checkUnique(array, n, array[j]);
			if (check) {
				s[k] = array[j];
				k++;
			}
		}
		sapxep(s, count);
		for(int k = 0; k < count; k++) {
		System.out.println(s[k]);
		}
	}

	public static boolean checkUnique(int[] array, int n, int x) {
		for (int i = 0; i < n; i++) {
			if (x == array[i]) {
				return false;
			}
		}
		return true;
	}
	public static void sapxep(int[] array, int n) {
		int tmp = 0;
		for (int i = 0; i < n; i++) {
			for(int j = i; j < n; j++) {
				if(array[i] < array[j]) {
					tmp = array[i];
					array[i] = array[j];
					array[j] = tmp;
				}
			}
		}
	}

}
