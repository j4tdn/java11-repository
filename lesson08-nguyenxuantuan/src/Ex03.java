import java.text.Normalizer;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Ex03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap vao 1 chuoi: ");
		String s = sc.nextLine();
		System.out.print(removeAccent(s));  // nhập vào chuỗi TIẾNG VIỆT có dấu bất kì sau đó xuất ra kết quả là chuỗi không dấu.
	}
	public static String removeAccent(String s) {
		  
		  String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
		  Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		  return pattern.matcher(temp).replaceAll("");
		 }

}
