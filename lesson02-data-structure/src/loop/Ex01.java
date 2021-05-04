package loop;

public class Ex01 {

	public static void main(String[] args) {
		printFor(4);
		demoBreakContinue(7);

	}
	private static void printFor(int n) {
		
	int s=0;
	   for(int i = 1; i <= n; i++) {
		s +=i;
	   }
	   System.out.println("tong " +s);
	   int i =1;
	   int k =0;
	   while(i <= n) {
		   k +=i;
		   System.out.println("tong " +k);
		   i++;
	   }
	   int  t=0;
	   while(true) {
		   
		   t +=i;
		   System.out.println("xx " +t);
		   i++;
		   if(i > n) break;
	   }
	}
	private static void printDoWhite(int n) {
		
		int i =1;
		do {
			System.out.println(i+ " ");
			i++;
		}while(i <= n);
	}
	private static void demoBreakContinue(int n) {
		for(int i = 1; i <= n; i++) {
			if(i == 4) {
			break;
			}
			System.out.println(i+ " ");
		}
		
		
		for(int i = 1; i <= n; i++) {
			if(i == 4) {
			continue;
			}
			System.out.println(i+ " ");
		}

		
	}
	
	

}
