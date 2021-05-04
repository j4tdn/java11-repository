package baitap;

import java.util.Scanner;

public class BT05 {


public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao so nguyen n: ");
        int n = sc.nextInt();
        System.out.println("So " + n + " trong he co so 2 = "
                + BT05.convertNumber(n));
    }

    public static String convertNumber(int n) {
         
        StringBuilder sb = new StringBuilder();
        int remainder = n;
        while (remainder > 0) {
            sb.append(remainder % 2);
            remainder = remainder / 2;
        }
        return sb.reverse().toString();
    }

}
