package ex02;

public class Ex02 {
	public static void main(String[] args) {
		String input = "lE vIEt HoAnG";
		System.out.println(input);
		System.out.println(formatter(input));
	}

	private static String formatter(String input) {
		String[] result = input.toLowerCase().replaceAll("\\s+", " ").trim().split("\\s");
		StringBuilder builder = new StringBuilder();
		for (String str : result) {
			builder.append(String.valueOf(str.charAt(0)).toUpperCase() + str.substring(1) + " ");
		}

		return builder.toString();
	}
}
