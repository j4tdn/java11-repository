package ex05;

public class App {

	public static void main(String[] args) {
		String str1 = "Java2blog";
		String str2 = "CoreJavaTutorial";
		App lcsMain = new App();
		System.out.println("String 1: " + str1);
		System.out.println("String 2: " + str2);
		System.out.println("Longest common subString is: " + lcs(str1, str2));
	}

	private static String lcs(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();
		int max = 0;

		int[][] dp = new int[m][n];
		int endIndex = -1;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (str1.charAt(i) == str2.charAt(j)) {
					if (i == 0 || j == 0) {
						dp[i][j] = 1;
					} else {
						dp[i][j] = dp[i - 1][j - 1] + 1;
					}
					if (max < dp[i][j]) {
						max = dp[i][j];
						endIndex = i;
					}
				}

			}
		}
		return str1.substring(endIndex - max + 1, endIndex + 1);
	}

	/*private static int lcs(char[] X, char[] Y, int m, int n) {
		if (m == 0 || n == 0)
			return 0;
		if (X[m - 1] == Y[n - 1])
			return 1 + lcs(X, Y, m - 1, n - 1);
		else
			return max(lcs(X, Y, m, n - 1), lcs(X, Y, m - 1, n));
	}

	private static int max(int a, int b) {
		return (a > b) ? a : b;
	} */
}