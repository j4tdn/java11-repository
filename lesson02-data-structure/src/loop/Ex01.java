package loop;

public class Ex01 {
	public static void main(String[] args) {
<<<<<<< HEAD
		// print all number < n
		int n = 7;
		printFor(n);
		printWhile(n);
		printDoWhile(n);
		demoBreakCountinue(n);
	}

	private static void printFor(int n) {
		System.out.println("---FOR---");
		for (int i = 0; i <= n; i++) {
			System.out.print(i + " ");
		}
	}

	private static void printWhile(int n) {
		System.out.println("\n---WHILE---");
		int i = 1;
		while (i <= n) {
=======
		//print all numbers < n
		int n = 9;
		printFor(n);
		printWhile(n);
		printWhile(n);
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
		while(i<=n) {
>>>>>>> ba78b3a (lesson02-03 02.05.2021)
			System.out.print(i + " ");
			i++;
		}
//		while(true) {
<<<<<<< HEAD
//			System.out.println(i + " ");
//			i++;
//			if(i > n) {
=======
//			System.out.print(i + " ");
//			i++;
//			if (i > n) {
>>>>>>> ba78b3a (lesson02-03 02.05.2021)
//				break;
//			}
//		}
	}
<<<<<<< HEAD

	private static void printDoWhile(int n) {
		System.out.println("\n---DO WHILE---");
		int i = 1;
		// skip 1st checking time
		do {
			System.out.print(i + " ");
			i++;
		} while (i <= n);
	}

	private static void demoBreakCountinue(int n) {
		System.out.println("\n---BREAK CONTINUE---");
		for (int i = 1; i <= n; i++) {
			if (i == 4) {
=======
	private static void printDoWhile(int n) {
		System.out.println("\n==== DO WHILE ====");
		int i = 1;
		// skip fist checking
		do {
			System.out.print(i + " ");
			i++;
		}
		while(i<=n);
	}
	private static void demoBreakContinue(int n) {
		System.out.println("\n====BREAK CONTINUE====");
		for (int i = 1; i <= n; i++) {
			if(i == 4) {
>>>>>>> ba78b3a (lesson02-03 02.05.2021)
				break;
			}
			System.out.print(i + " ");
		}
<<<<<<< HEAD

		System.out.println();

		for (int i = 1; i <= n; i++) {
			if (i == 4) {
=======
		System.out.println();
		for (int i = 1; i <= n; i++) {
			if(i == 4) {
>>>>>>> ba78b3a (lesson02-03 02.05.2021)
				continue;
			}
			System.out.print(i + " ");
		}
<<<<<<< HEAD
=======
		System.out.println();
>>>>>>> ba78b3a (lesson02-03 02.05.2021)
	}
}
