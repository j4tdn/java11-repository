package ex04;

public class App {
	public static void main(String[] args) {
		String _str = "Wellcome   to JAVA10     class";
		
		String str = _str.replaceAll("\\s+", " ");
		
		System.out.println(str);
		
		StringBuilder strBuff = new StringBuilder();

		for (int i = 0; i < str.length(); ++i) {
			if (str.charAt(i) != ' ') {
				strBuff.append(str.charAt(i));
			}
			else {
				System.out.print(strBuff.reverse());
				System.out.print("\s");
				strBuff.setLength(0);
			}

			if (i == str.length() - 1) {
				System.out.println(strBuff.reverse());
				strBuff.setLength(0);
			}
		}
	}
}
