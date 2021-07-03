package homework07;

public class Hw07 {
	public static void main(String[] args) {
		String s = "hhhhhhlllllieeeeeeebbd";
		as(s);
	}

	private static void as(String s) {
		char[] c = s.toCharArray();
		char tmp = c[0];
		
		char cMax = 0;
		int count = 0;
		int max = 0;

		for (int i = 0; i < c.length - 1; i++) {
			if (c[i] == tmp) {
				count++;
			} else {
				if (count > max) {
					max = count;
					cMax = tmp;
				}
				tmp = c[i];
				count = 1;
			}
		}
		String r = "";
		for (int i = 0; i < max; i++) {
			r += cMax;
		}
		System.out.println("max result: " + max + " " + r);
	}
}
