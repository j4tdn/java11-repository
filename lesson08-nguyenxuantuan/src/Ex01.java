import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap vao 1 chuoi: ");
		String s = sc.nextLine();
		System.out.println(eachChar(s));   // In ra mỗi kí tự trên một dòng
		System.out.println(eachWord(s));   // In ra mỗi từ trên mỗi dòng, các từ các nhau bởi kí tự trống
		System.out.println(revertChar(s));  // In ra chuỗi đảo ngược theo kí tự
		System.out.println(revertWord(s));  // In ra chuỗi đảo ngược theo từ
	}
	
	private static String eachChar(String s) {
		String result = "";
		s = s.trim();
		String[] words = s.split("");
		for (String word:words) {
			result += (word + "\n");
		}
		return result;
	}
	private static String eachWord(String s) {
		String result = "";
		s = s.trim();
		String[] words = s.split("[\\s]++");
		for (String word:words) {
			result += (word + "\n");
		}
		return result;
	}
	
	private static String revertChar(String s) {
		String result = "";
		s = s.trim();
		String[] words = s.split("");
		for (int i = words.length-1; i>=0; i--) {
			result += words[i];
		}
		
		return result;
	}
	private static String revertWord(String s) {
		String result = "";
		s = s.trim();
		String[] words = s.split("[\\s]++");
		for (String word:words) {
			String revert = "";
			for (int i = word.length()-1; i >= 0; i--) {
				revert += word.charAt(i);
			}
			
			result += revert + " ";
		}
		
		return result;
	}
	
}
