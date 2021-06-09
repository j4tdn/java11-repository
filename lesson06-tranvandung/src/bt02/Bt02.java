package bt02;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bt02 {
	public static void main(String[] args) {
		String pass1 = getPassWord();
		System.out.println("Password: " + pass1);
	}

	public static String getPassWord() {
		Scanner ip  = new Scanner(System.in);
		String pass ="";
		while (true) {
			System.out.println("Enter password: ");
			pass = ip.nextLine();
			Pattern p1 = Pattern.compile("^.*[A-Z]+.*$");
			Pattern p2 = Pattern.compile("^.*[a-z]+.*$");
			Pattern p3 = Pattern.compile("^.*[0-9]+.*$");
			Pattern p4 = Pattern.compile("^.*[!@#$%^&*-]+.*$");
			Pattern p5 = Pattern.compile(".{8,256}");

			if (p1.matcher(pass).find() && p2.matcher(pass).find() && p3.matcher(pass).find() && p4.matcher(pass).find()
				&& p5.matcher(pass).find()) {
				System.out.println("Password Registration Successful!!");
				break;
			}
			//Password nhap vao khong thoa >1 dieu kien thi in bang huong dan
			if (p1.matcher(pass).find() || p2.matcher(pass).find() || p3.matcher(pass).find() || p4.matcher(pass).find()) {
				System.out.println("=============================================");
				System.out.println("Pass work at least 8 char at most 256 char!");
				System.out.println("Pass work need at least 1 special char");
				System.out.println("Pass work need at least 1 number");
				System.out.println("Pass work need at least 1 lowercase char");
				System.out.println("Pass work need at least 1 uppercase char");
				System.out.println("=============================================");
			}
			//Password nhap vao khong thoa 1 dieu kien thi in dong huong dan con thieu
			if (p1.matcher(pass).find() && p2.matcher(pass).find() && p3.matcher(pass).find()
				&& p4.matcher(pass).find()) {
				System.out.println("Pass work at least 8 char at most 256 char, try again!");
			}
			if (p1.matcher(pass).find() && p2.matcher(pass).find() && p3.matcher(pass).find()
				&& p5.matcher(pass).find()) {
				System.out.println("Pass work need at least 1 special char, try again!");
			}
			if (p1.matcher(pass).find() && p2.matcher(pass).find() && p4.matcher(pass).find()
				&& p5.matcher(pass).find()) {
				System.out.println("Pass work need at least 1 number, try again!");
			}
			if (p1.matcher(pass).find() && p3.matcher(pass).find() && p4.matcher(pass).find()
				&& p5.matcher(pass).find()) {
				System.out.println("Pass work need at least 1 lowercase char, try again!");
			}
			if (p2.matcher(pass).find() && p3.matcher(pass).find() && p4.matcher(pass).find()
				&& p5.matcher(pass).find()) {
				System.out.println("Pass work need at least 1 uppercase char, try again!");
			}
		}
		return pass;
	}
}
