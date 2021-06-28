package Ex04;

public class Convert {
	public static void main(String[] args) {
		String msg = "Welcome toJAVA10 class";

		for (String w : revert(msg)) {
			System.out.print(w);
		}
	}

	public static String[] revert(String msg) {

		StringBuffer stringBuffer = new StringBuffer(msg);

		String reverseString = stringBuffer.reverse().toString();

		String[] newMsg = reverseString.split(" ");

		return newMsg;

	}

}
