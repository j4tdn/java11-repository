package ex02;

public class Ex02 {
	public static void main(String[] args) {
		String name = "  aDam Le vAN john Son   ";
		capitalFirstLetter(name);
	}

	public static void capitalFirstLetter(String name) {
		name = name.trim().toLowerCase();
		name = name.replaceAll("\\s+", " ");
		String[] temp = name.split(" ");
		name = "";
		for (int i = 0; i < temp.length; i++) {
			name += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
			if (i < temp.length - 1)
				name += " ";
		}
		System.out.println(name);
	}
}