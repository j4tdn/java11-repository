package loop;

public class Ex01 {
	public static void main(String[] args) {
		// print all number < n
		int n = 8;
		printForNumber(n);
		printWhileNumber(n);
		printDoWhileNumber(n);
		demoBearkContinue(n);
	}

	private static void printForNumber(int n) {
		System.out.println("========For================");
		for (int i = 1; i <= n; i++) {
			System.out.print(i + " ");
		}
	}

	private static void printWhileNumber(int n) {
		System.out.println("\n=======While================");
		int i = 1;
		while (i <= n) {
			System.out.print(i + " ");
			i++;
		}

//		while(true) {
//			System.out.println(i + " ");
//			i++;
//			if(i > n) {
//				break;
//			}
//		}
	}

	private static void printDoWhileNumber(int n) {
		System.out.println("\n=======Do-While================");
		int i = 1;
		// skip 1st checking
		do {
			System.out.print(i + " ");
			i++;
		} while (i <= n);
	}

	private static void demoBearkContinue(int n) {
		System.out.println("\n=======Beak ======Continue========");
		for(int i = 1; i <= n; i++) {
			if(i == 4) {
				break;
			}
			System.out.print(i + " ");
		}
		System.out.println();
		for(int i = 1; i <= n; i++) {
			if(i == 4) {
				continue;
			}
			System.out.print(i + " ");
		}
	}
	
}
