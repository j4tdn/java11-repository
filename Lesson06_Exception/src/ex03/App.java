package ex03;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Email: ");
		String mail = sc.nextLine();
		if(mail == null) {
			System.out.println("Please again !");
			return;
		}
		
		Pattern pattern1 = Pattern.compile("^@");
		Matcher matcher1 = pattern1.matcher(mail);

		
		if( !matcher1.find() || (mail.lastIndexOf("@",1) == mail.length())) {
			System.out.println("Correct");
		}
		else
			System.out.println("Incorrect!");
	}

}
