package ex03;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
	public static void main(String[] args) {
		while (true) {
			Scanner ip = new Scanner(System.in);
			System.out.print("Nhập địa chỉ email: ");
			String email = ip.nextLine();

			try {
				emailAddress(email);
				System.out.println("Địa chỉ email hợp lệ!");
				break;
			} catch (EmailException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private static boolean emailAddress(String email) throws EmailException {
		String emailPattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		Pattern p = Pattern.compile(emailPattern);
		Matcher m = p.matcher(email);
		if (!m.matches()) {
			throw new EmailException("Địa chỉ email không hợp lệ!");
		}
		return m.matches();

	}
}
