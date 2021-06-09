import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) throws Exception {
		String password = "";
		do {
			try {
				password = input();
				System.out.println("Mật khẩu hợp lệ");
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (true);
	}
	
	private static String input() throws Exception {
		Scanner sc = new Scanner(System.in);
		String s ="";
		System.out.printf("Nhập mật khẩu: ");
		s = sc.nextLine();
		String err = "";
		if (s.length()<8) {
			err += "Mật khẩu phải có ít nhất 8 ký tự\n";
		}
		if (s.length()>256) {
			err += "Mật khẩu có độ dài tối đa là 256\n";
		}
		boolean dk1 = false, dk2 = false, dk3 = false, dk4 = false;
		for (int i=0; i<s.length(); i++) {
			if (s.charAt(i)>='a' && s.charAt(i)<='z') {
				dk1 = true;
			} else if (s.charAt(i)>='0' && s.charAt(i)<='9') {
				dk2 = true;
			} else if (s.charAt(i)>='A' && s.charAt(i)<='Z') {
				dk3 = true;
			} else if (s.charAt(i)>=33 && s.charAt(i)<=126) {
				dk4 = true;
			}
		}
		if (!dk1) {
			err += "Mật khẩu phải có ít nhất một chữ cái thường\n";
		}
		if (!dk2) {
			err += "Mật khẩu phải có ít nhất một chữ số\n";
		}
		if (!dk3) {
			err += "Mật khẩu phải có ít nhất một chữ cái hoa\n";
		}
		if (!dk4) {
			err += "Mật khẩu phải có ít nhất một kí tự đặc biệt\n";
		}
		
		if (err != "") {
			throw new Exception(err);
		}
		return s;
	}

}