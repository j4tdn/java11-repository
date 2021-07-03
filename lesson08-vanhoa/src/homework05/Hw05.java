package homework05;

public class Hw05 {
	public static void main(String[] args) {
		String m = "SABCEDEABC";
		String n = "ABCEDCBBCK";
		int[][] matrix = new int[m.length()][n.length()]; // matrix dung de truy vet
		for (int i = 0; i < m.length(); i++) {
			for (int j = 0; j < n.length(); j++) {
				matrix[i][j] = 0;
			}
		}
	}

	private static String getLongCommonString(String s1, String s2) {

		return s1;
	}

	private static int max(int a, int b) {
		return a > b ? a : b;
	}

}
