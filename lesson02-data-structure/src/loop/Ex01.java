package loop;

public class Ex01 {
	public static void main(String[] args) {
		printFor(5);
		printWhile(5);
		printDoWhile(5);
		demoBreak(6);
		demoContinue(6);
	}
	private static void printFor(int n) {
		System.out.println("\n=====FOR======");
		for(int i = 0; i < n; i++) {
			System.out.println(i);
		}
	}
	private static void printWhile(int n) {
		System.out.println("\n=====WHILE======");
		int i = 0;
		while(i < n) {
			System.out.println(i+ " ");
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
	private static void printDoWhile(int n) {
		System.out.println("\n=====DO WHILE======");
		int i = 0;
		do{
			System.out.println(i+ " ");
			i++;
		}
		while(i < n);
	}
	private static void demoBreak(int n) {
		for(int i = 0; i <= n; i++) {
			if(n == 4){
				break;
			}
			System.out.println(i + " ");
		}
	
	}
	private static void demoContinue(int n) {
		for(int i = 0; i <= n; i++) {
			if(n == 4){
				continue;
			}
			System.out.println(i + " ");
		}
	}
	
}
