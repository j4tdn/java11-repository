

import java.util.Scanner;

public class Ex07 {
	public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        System.out.print("Nhap n: ");
        int n = ip.nextInt();
        String bin = Integer.toBinaryString(n);
        System.out.println(bin);
	}
}