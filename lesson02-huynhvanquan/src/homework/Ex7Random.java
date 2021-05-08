package homework;

import java.util.Random;

public class Ex7Random {
	public static void main(String[] args) {
		Random rand = new Random();
		int n;
		int[] numList = new int[5]; 
		int i = 0;
		while (i != 5) {
			n = 20 + rand.nextInt(11);
			if (!isContains(n, numList)) {
				numList[i++] = n;
				System.out.print(n + " ");
			}
		}
	}
	static boolean isContains(int n, int[] numList) {
		for (int j : numList) {
			if (j == n) {
				return true;
			}
		}
		return false;
	}
}
