package ex02;

public class Ex02MissingNum {
public static void main(String[] args) {
	int[] A;
	int n = A.length;

}
public static int getMissingNumber(int [] A , int n) {
	int temp = A[0];
	for (int i = 0; i < n; i++) {
		if (A[i] > temp) {
			temp = A[i];
}
	}
}
