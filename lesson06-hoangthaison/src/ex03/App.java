package ex03;

import java.util.Scanner;
import java.util.regex.Pattern;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean check;
		System.out.println("Email: ");
		try {
		String mail = sc.nextLine();
		check = Pattern.matches("[^@][0-9a-zA-Z]*@([a-z]+\\\\.[a-z]+|[a-z]+\\\\.[a-z]+\\\\.[a-z]+)", mail);
		if(check) {
			System.out.println("OK");
		}
		else System.out.println("KO");
		}
		catch(RuntimeException e) {
			e.printStackTrace();
		}

	}
}
