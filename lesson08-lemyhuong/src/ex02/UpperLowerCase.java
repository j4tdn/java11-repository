package ex02;

public class UpperLowerCase {
	public static void main(String[] args) {
		String name = "  aDam Le vAN john Son   ";
		System.out.println("name: " + upperFirstLetterInWords(name));
		
	}
	
	private static String upperFirstLetterInWords(String line) {
		String name = line;
		name = name.replaceAll("[,\\s]+", " ").trim();
		String[] splitName = name.split(" ");
		
		name = "";
		for (int i = 0; i < splitName.length; i++) {
			name += String.valueOf(splitName[i].charAt(0)).toUpperCase() + splitName[i].substring(1).toLowerCase();
			if (i < splitName.length) {
				name += " ";

			}
		}
		
		return name;
	}
}
