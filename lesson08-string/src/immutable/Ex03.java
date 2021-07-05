package immutable;

public class Ex03 {
	public static void main(String[] args) {
		/**
		 1. Tính chiều dài của chuỗi s
		 2. Nối chuỗi s1 vào chuỗi s
		 3. Lấy một ký tự tại vị trí index trong chuỗi s
		 4. Duyệt từng phần tử trong chuỗi
		 5. Tìm vị trí xuất hiện đầu tiên, cuối cùng của kí tự  trong chuỗi s
		 */
		String s = "Box";
		System.out.println("Length: " + s.length());
		//s += "Layout";
		s = s.concat("Layout");

		System.out.println("2: " + s);
		
		System.out.println("charAt(4): " + s.charAt(4));
		
		for(int i = 0; i < s.length(); i++) {
			System.out.print(s.charAt(i) + "---");
		}
		
		System.out.println("\nindexOf: " + s.indexOf(""));
		System.out.println("lastIndexOf: " + s.lastIndexOf("t"));
	}
}
