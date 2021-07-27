package ex04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ex02.Input;

public class Ex01 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		long m, n;
		do {
			try {
				System.out.println("Nhap M: ");
				m = Long.parseLong(ip.next());
				System.out.println("Nhap N: ");
				n = Long.parseLong(ip.next());
				check(m, n);
				break;
			} catch (Input e) {
			}
		}while(true);
		if (equals(uoc(m),uoc(n))) System.out.println("YES");
		else System.out.println("No");
	}
	
	private static void check(Long m, long n) throws Input {
		if (m < 2 || n < 2 || m > n || m > 300000000000000000L || n > 300000000000000000L) {
            throw new Input("Input Error");
        }
	}
	
	private static List<Integer> uoc(Long n) {
		List<Integer> digits = new ArrayList<>();
		int i = 2;
		 while(i<=n/2)
		    {
		        if(n%i==0) {
		        	if (isPrime(i)) {
		        		digits.add(i);
		        	}
		        } 
		        i++;
		     }
		return digits;
	}
	
	public static boolean isPrime(int n) {
	       if (n <= 1) {
	           return false;
	       }
	       for (int i = 2; i <= Math.sqrt(n); i++) {
	           if (n % i == 0) {
	               return false;
	           }
	       }
	       return true;
	   }
	
	private static boolean equals(List<Integer> m, List<Integer> n) {
		if (m.size() != n.size()) return false;
		for(int i = 0; i< m.size(); i++) {
			if(m.get(i)!=n.get(i)) return false;
		}
		return true;
	}
}
