package ex02;

import java.util.Scanner;

import ex03.EmailException;

public class Ex02 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		String account = "LeVietHoang";
		String passwork;
		while (true) {
			try {
				System.out.print("Nhap Passwork :  ");
				passwork = ip.nextLine();
				System.out.println("Account : " + account);
				System.out.println("Passwor : " + inputPW(account, passwork));
				break;
			} catch (PassworkException e) {
				System.out.println(e.getMessage());
				System.out.println("=====================");
				System.out.println("Enter A Valid Passwork   ");
			}
		}
	}

	private static String inputPW(String account, String passwork) throws PassworkException {
		int countLC = 0;
		int countUC = 0;
		int countNB = 0;
		int countSC = 0;
		String specialC = "~!@#$%^&*()-_=+[]{}|;:,.<>/?";

		for (int i = 0; i < passwork.length(); i++) {
			if (passwork.charAt(i) >= '0' && passwork.charAt(i) <= '9') {
				countNB++;
			}
			if (Character.isUpperCase(passwork.charAt(i))) {
				countUC++;
			}
			if (Character.isLowerCase(passwork.charAt(i))) {
				countLC++;
			}
		}

		for (int i = 0; i < passwork.length(); i++) {
			for (int j = 0; j < specialC.length(); j++) {
				if (passwork.charAt(i) == specialC.charAt(j)) {
					countSC++;
				}
			}
		}

		if (passwork.length() < 8 || passwork.length() > 256 || countLC == 0 || countUC == 0 || countSC == 0
				|| countNB == 0 || passwork.toLowerCase().contains(account.toLowerCase())) {
			throw new PassworkException("INVALID PASSWORK !!!");
		}

		return passwork;
	}
}
