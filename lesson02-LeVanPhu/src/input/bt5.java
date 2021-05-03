package input;

public class bt5 {
	public static void main(String[] args) {
		 heCoSo(255);
		
	}
	public static void heCoSo(int n) {
		int b = 0;
		int a[] = new int[40];
		
		while (n / 2 != 0) {
			int m = n;
			m = m % 2;
			a[b] = m;
			b++;
			n = n / 2;
			if(n==1) {
				a[b]=1;
			}
				
		}
		for(int i=b;i >= 0;i--) {
			System.out.print(a[i]);
		}
		
	}
}