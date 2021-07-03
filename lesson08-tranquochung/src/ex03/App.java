package ex03;

import java.text.Normalizer;
import java.text.Normalizer.Form;

public class App {
	public static void main(String[] args) {
		String str = "Em có yêu anh không anh để anh biết còn ch�?\n"
				+ "Em xin lỗi em đã có thái độ không đúng với anh";

		String strNew = Normalizer.normalize(str, Form.NFD);

		String result = strNew.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
		System.out.println(result);
	}
}
