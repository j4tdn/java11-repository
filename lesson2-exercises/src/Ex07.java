import java.util.concurrent.ThreadLocalRandom;

public class Ex07 {
	public static void main(String[] args) {
		int[] a = new int[5];
		int i = 0;
		while(i<5){
			int ranNum = ThreadLocalRandom.current().nextInt(20, 30);
			if (check(ranNum, a)) {
				a[i] = ranNum;
				i++;
				System.out.println("Random number is " + ranNum);
			}
		}
	}

	public static boolean check(int n, int[] a) {
		for (int i = 0; i < 4; i++) {
			if (n == a[i])
				return false;
		}
		return true;
	}
}
