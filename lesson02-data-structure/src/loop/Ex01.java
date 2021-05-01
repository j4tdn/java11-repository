package loop;

public class Ex01 {
	public static void main(String[] args) {
		// print all numbers < n
		int n = 7;
		printFor(n);
		printWhile(n);
		printDoWhile(n);
		demoBreakContinue(n);
	}

	private static void printFor(int n) {
		System.out.println("==== FOR ====");
		for (int i = 1; i <= n; i++) {
			System.out.print(i + " ");
		}
	}

	private static void printWhile(int n) {
		System.out.println("\n==== WHILE ====");
		int i = 1;
		while (i <= n) {
			System.out.print(i + " ");
			i++;
		}

//		while(true) {
//			System.out.print(i + " ");
//			i++;
//			if (i > n) {
//				break;
//			}
//		}
	}

	private static void printDoWhile(int n) {
		System.out.println("\n==== WHILE ====");
		int i = 1;
		// skip 1st checking time
		do {
			System.out.print(i + " ");
			i++;
		} while (i <= n);
	}
	// n = 7
	private static void demoBreakContinue(int n) {
		System.out.println("\n== BREAK CONTINUE ===");
		for (int i = 1; i <= n; i++) {
			System.out.print(i + " ");
			if (i == 4) {
				break;
			}
			
		}
		
		System.out.println();
		
		for (int i = 1; i <= n; i++) {
			System.out.print(i + " ");
			if (i == 4) {
				continue;
			}
		}
	}
}
