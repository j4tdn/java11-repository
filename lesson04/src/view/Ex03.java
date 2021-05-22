package view;

public class Ex03 {

	public static void main(String[] args) {
		printTriangularPascal(4);
		
	}
	
	private static int combinate(int k, int n) {
		if(k == 0 || k == n) return 1;
		if(k == 1) return n;
		return combinate(k-1, n-1) + combinate(k, n-1);
	}
	private static void printTriangularPascal(int n) {
		for (int i = 1; i <= n; i++) {
			for(int j = 0; j <=i; j++) {
				System.out.print(combinate(j, i) + " ");
			}
			System.out.println("\n");	
		}
		
	}


}