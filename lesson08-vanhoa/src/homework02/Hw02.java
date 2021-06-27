package homework02;

import java.util.Scanner;

public class Hw02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String fullname = "";
		
		while (true) {
			
			System.out.print("Enter fullname: ");
			fullname = sc.nextLine();
			try {
				isValidName(fullname);
				break;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("try again");
			}
		}
		String result = getTransform(fullname);
		System.out.println(result);

	}

	private static boolean isValidName(String name) throws Exception {
		if (!name.matches("[A-Za-z\\s]+")) {
			throw new Exception("non-vaild name!!!");
		}
		return true;
	}
	
	private static String getTransform(String s) {
		if(s == null) {
			return null;
		}
		String[] words = s.split("\\s");
		for (int i = 0; i < words.length; i++) {
			
			char[] charArray = words[i].toCharArray();
			
			for (int j = 0; j < charArray.length; j++) {
				// A to Z 65 - 90 ASCII
				if(j == 0 && charArray[j] <= 122 && charArray[j] >= 97) {
					charArray[j] -= 32;
				}
				// a to z 97 - 122 ASCII
				if(j != 0 && charArray[j] <= 90 && charArray[j] >=65) {
					charArray[j] += 32;
				}
			}
			words[i] = String.valueOf(charArray);
		}
		
		return String.join(" ", words);
	}
}
