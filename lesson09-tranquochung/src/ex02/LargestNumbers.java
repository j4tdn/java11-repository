package ex02;

public class LargestNumbers {
	public static void main(String[] args) {
		String s = "01a2b3456cde478";
		for (String item : getLargestNumbers(s)) {
			System.out.print(item);
		}
	}

	public static String[] getLargestNumbers(String s) {
		String[] cutS = s.split("[a-z]");
		String[] rs = new String[cutS.length];
		for (String item : cutS) {
			if (item.charAt(0) == '0') {
				item = item.substring(0);
			}
		}
		int maxlg = cutS[0].length();
		for (int i = 0; i < cutS.length; i++) {
			if (cutS[i].length() > maxlg)
				maxlg = cutS[i].length();
		}
		int count = 0;
		for (String st : cutS) {
			if (st.length() == maxlg) {
				rs[count++] = st;
			}
		}
		return rs;
	}
}
