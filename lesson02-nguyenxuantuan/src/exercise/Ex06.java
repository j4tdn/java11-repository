package exercise;

public class Ex06 {
	public static void main(String[] args) {
		countPrimeNumber(1124);
	}
	public static boolean isPrimeNumber(int n) {
        // so nguyen n < 2 khong phai la so nguyen to
        if (n < 2) {
            return false;
        }
        // check so nguyen to khi n >= 2
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
	public static void countPrimeNumber(int n) {
		int count = 0;
		for(int i = 2; i < 100000000; i++) {
			if(isPrimeNumber(i))
			{
				count++;
				if(count == n) {
					 System.out.println(i);
				}
			}
		}
	}
}
