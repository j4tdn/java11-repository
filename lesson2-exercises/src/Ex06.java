
public class Ex06 {
	public static void main(String[] args) {
		int n = 0, i = 0;
		while(n!=200) {
			if(isPrimeNumber(i)) n++;
			i++;
		}
		System.out.println(i-1);
	}
	
	public static boolean isPrimeNumber(int n) {
		if(n<2) return false;
		for(int i = 2; i<=(int)Math.sqrt(n);i++) {
			if(n%i==0) return false;
		}
		return true;
	}
}
