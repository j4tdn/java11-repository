package homework03;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.regex.Pattern;

public class Hw03 {
	public static void main(String[] args) {
		String str = "Đi mô thì cũng nhớ về Hà Nội";
		System.out.println(str);
		System.out.println(getTransform(str));
		System.out.println(removeAccent(str));
	}
	
	private static String getTransform(String s) {
		// hard code
		s = s.replaceAll("[ăắằẵẳặâấầẩẫậáàảãạ]+", "a");
		s = s.replaceAll("[đ]", "d");
		s = s.replaceAll("[éèẻẽẹêếềểễệ]", "e");
		s = s.replaceAll("[íìỉĩị]", "i");
		s = s.replaceAll("[óòỏõọơớờởỡợôốồổỗộ]", "o");
		s = s.replaceAll("[úùủũụưứừửữự]", "u");
		s = s.replaceAll("[ýỳỷỹỵ]", "y");
		
		s = s.replaceAll("[ÁÀẢÃẠĂẮẰẲẴẶÂẤẦẨẪẬ]+", "A");
		s = s.replaceAll("[Đ]", "D");
		s = s.replaceAll("[ÉÈẺẼẸÊẾỀỂỄỆ]", "E");
		s = s.replaceAll("[ÍÌỈĨỊ]", "I");
		s = s.replaceAll("[ÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢ]", "O");
		s = s.replaceAll("[ÚÙỦŨỤƯỨỪỬỮỰ]", "U");
		s = s.replaceAll("[ýỳỷỹỵ]", "Y");
		return s;
	}
	
	private static String removeAccent(String s) {
		s = Normalizer.normalize(s, Form.NFD);
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		s = pattern.matcher(s).replaceAll("");
		s = s.replaceAll("đ", "d");
		s = s.replaceAll("Đ", "D");
		return s;
	}
}
