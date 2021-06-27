package ex03;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class App {
	public static void main(String[] args) {
		String text = "Em có yêu anh không để anh biết còn chờ\r\n"
				+ "Em xin lỗi em đã có thái độ không đúng với anh";
		String temp = Normalizer.normalize(text, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		String result = pattern.matcher(temp).replaceAll("");
		System.out.println(result);
	}
}
