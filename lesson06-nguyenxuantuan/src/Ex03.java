
import java.util.Scanner;
public class Ex03 {
	public static void main(String[] args) {
		String email = "";
		do {
			try {
				email = input();
				System.out.println("Email hợp lệ");
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		} while (true);
	}
	
	private static String input() throws EmailException {
		Scanner sc = new Scanner(System.in);
		String EMAIL_PATTERN = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
		// [\\w-]+ : chỉ chứa chữ cái, chữ số hoặc dấu gạch ngang
		// ký tự @ ở giữa
		// sau @ là tên miền có dạng domain.x với x có độ dài từ 2-4 ký tự
		String email = "";
		System.out.println("Nhập email: ");
		email = sc.nextLine();
		
		if (!email.matches(EMAIL_PATTERN)) {
			throw new EmailException();
		}
		
		return email;
	}


}
