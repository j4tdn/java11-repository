package data;

public class Ex07PrimitiveVsObject {
	public static void main(String[] args) {
		// Check a character is number or not
		// primitive: kiểu nguyên thủy
		// Object: kiểu đối tượng
		char input = '8';
		System.out.println("primitive: " + isDigit(input));
		System.out.println("Object: "+ Character.isDigit(input));
		
		String s = "123";
		// [0-9]: là kiểm tra chuỗi nhập vào phải là từ 0-9 hay không
		// {1,}: là tính từ ký tự đầu tiên, là 2 thì là 2 ký tự đầu tiên có phải số k
		// hoặc dùng [0-9]+: từ 0 đến 9 có trên 1 ký tự
		System.out.println("isNumber: "+ s.matches("[0-9]{1,}"));
	}
	
	private static boolean isDigit (char input) {
		return input >= '0' && input <= '9';
	}
}
