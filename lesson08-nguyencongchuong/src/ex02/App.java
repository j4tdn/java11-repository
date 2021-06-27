package ex02;

public class App {
	public static void main(String[] args) {
		String name = "nguYễn   cônG chưƠng";
		try {
			isInvalid(name);

		} catch (NameException e) {
			System.out.println(e.getMessage());
			
		}
		for(String names : name.split("\\s+")) {
			String firstLetter = names.substring(0, 1).toUpperCase();
			String remainingLetters = names.substring(1).toLowerCase();
			name = firstLetter + remainingLetters + " ";
			System.out.print(name);
		}

	}

	private static boolean isInvalid(String name) throws NameException {
		if (!name.matches("[A-Za-zÀ-ỹ\\\s]+")) {
			throw new NameException("Invalid name!");
		}
		return true;
	}
}
