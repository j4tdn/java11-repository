package loop;

public class Ex01 {
	public static void main(String[] args) {
		int n = 7;
		printFor(n);
		printWhile(n);
		printDoWhile(n);
		demoBreakContinue(n);

	}

	private static void printFor(int n) {
		System.out.println("..");
		for(int i = 1; i < n; i++) {
			System.out.print(i + "");
		}
	}
	private static void printWhile(int n) {
		System.out.println("\n>>");
		int i = 1;
			while(i <= n) {
			System.out.print(i + "");
			i++;
		}
//		while(true) {
//			System.out.println(i + " ");
//			i++;
//			if (i > n) {
//				break;
//			}
//		}
	}
	private static void printDoWhile(int n) {
		System.out.println("\n>>");
		int i = 1;
		do {
			System.out.print(i + "");
			i++;
		}while (i <= n);
	}
	private static void demoBreakContinue(int n) {
		for (int i = 1; i <= n; i++) {
			if (i == 4) {
				break;
			}
			System.out.println(i + " ");
		}
		
		for (int i = 1; i <= n; i++) {
			if (i == 4) {
				continue;
			}
			System.out.println(i + " ");
		}
		
	}
}