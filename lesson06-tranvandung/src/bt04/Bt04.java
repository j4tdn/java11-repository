package bt04;

import java.util.Scanner;

public class Bt04 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.println("Nhap so: ");
		int n = ip.nextInt();
		int tram = n / 100;
		int chuc = n / 10 % 10;
		int dv = n % 10;

		String numberText = "";
		if (tram != 0) {
			numberText += readNumber(tram) + " Trăm ";
		}
		if (chuc != 0) {
			numberText += readNumber(chuc) + " Mươi ";
		} else if (tram != 0 && chuc == 0) {
			numberText += " Lẻ ";
		}

		if (dv != 0) {
			if (chuc != 0 && dv == 5) {
				numberText += "Lăm ";
			} else {
				numberText += readNumber(dv);
			}
		}

		System.out.println(numberText);

	}

	public static String readNumber(int num) {
		switch (num) {
		case 0:
			break;
		case 1:
			return "Một";
		case 2:
			return "Hai";
		case 3:
			return "Ba";
		case 4:
			return "Bốn";
		case 5:
			return "Năm";
		case 6:
			return "Sáu";
		case 7:
			return "Bảy";
		case 8:
			return "Tám";
		case 9:
			return "Chín";
		}
		return "";

	}
}
