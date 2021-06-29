package lesson08bt;
import java.text.Normalizer;
import java.util.regex.Pattern;

public class Ex03 {
	public static void main(String[] args) {
		String input  = "Em có yêu anh không để anh biết còn chờ";
		System.out.println(input);
		System.out.println(removeAccent(input));
	}
	
	 private static String removeAccent(String s) {
		  
		  String  str= Normalizer.normalize(s, Normalizer.Form.NFD);
		  Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		  return pattern.matcher(str).replaceAll("");
		 }

}
