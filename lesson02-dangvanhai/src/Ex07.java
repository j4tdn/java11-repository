import java.util.Random;

public class Ex07 {
	public static void main(String[] args) {
		int[] result = getRandom(20, 30);
		for (var i : result) {
			System.out.print(i + " ");
		}
	}

	private static int[] getRandom(int a, int b) {
		int[] result = new int[5];
		for (int i = 0; i < 5; i++) {
			Random rd = new Random();
			int temp = -1;
			do {
				temp = a + rd.nextInt(b - a) + 1;
			} while (contains(result, temp));
			result[i] = temp;
		}
		return result;
	}

	private static boolean contains(int[] result, int temp) {
		for (int i = 0; i < result.length; i++) {
			if (result[i] == temp)
				return true;
		}
		return false;
	}
}
