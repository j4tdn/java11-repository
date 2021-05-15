import java.util.Scanner;
public class Ex05 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("nhap n: ");
		int n = scanner.nextInt();
		convert(n);
	}
	
	public static void convert(int n) {
		if (n==0) System.out.println(0);
		int [] arr = new int[100];
		int i = 0;
		while(n>0) {
			arr[i] = n%2;
			n=n/2;
			i++;
		}
		for(int j = i-1;j>=0;j--) {
			System.out.print(arr[j]);
		}
	}
}
