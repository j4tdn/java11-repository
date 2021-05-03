package input;

public class bt6 {
	public static void main(String[] args) {
		Dem();
	}
	private static boolean prime(int n) {
		if(n<2)
			return false;
		for(int i = 2;i<= Math.sqrt(n);i++) {

			if(n % i == 0) {
				return false;
			}
		}
		return true;
		
  }
	private static void Dem() {
		int dem=0;
		int i = 2;
		while(dem != 200) {
			if(prime(i)) {
				dem++;
			}
			if(dem == 200) {
				System.out.println("So nguyen to thu 200: " +i);
			}
			i++;
		}
	}
}
