package bt;

import java.text.Normalizer;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Bt03 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter String: ");
		String s = ip.nextLine();
		System.out.println("String After Convert: " + covertToString(s));
	}

	public static String covertToString(String s) {
		try {
			String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
			Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
			return pattern.matcher(temp).replaceAll("");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}