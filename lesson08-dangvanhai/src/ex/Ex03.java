package ex;

import java.text.Normalizer;

public class Ex03 {
	public static void main(String[] args) {
		String line = "Một chiếc áo màu tím mộng mer.... Tranh thủ săn sale 1xx nèee";
		System.out.println(deAccent(line));
	}

	private static String deAccent(String str) {
		str = Normalizer.normalize(str, Normalizer.Form.NFD);
		return str.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
	}
}
