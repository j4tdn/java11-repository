package ex04;

public class App {
	public static void main(String[] args) {
		
		String text  = "Chaof sadasd  asd asdasd   ds".trim();
		
		//Phương thức trim() được sử dụng để xóa khoảng trẳng ở đầu và cuối chuỗi.
		//Giá trị unicode của khoảng trắng là '\u0020'. 
		//Phương thức trim() kiểm tra giá trị unicode trước và sau chuỗi,
		//nếu tồn tại thì xóa bỏ khoảng trắng đi và trả về chuỗi không có khoảng trắng ở đầu và cuối.
		System.out.println(text.replaceAll("\\s\\s+", " ").trim());
		
		
		
		/*
		 * StringBuilder str = new StringBuilder();		
		 *
		 *for(int i = 0; i < text.length(); i++) {
		 *
		 *	if(text.charAt(i)!= ' ' ) {
		 *	
		 *		str.append(text.charAt(i));
		 *	}
		 *	else if(text.charAt(i) == ' ') {
		 *		System.out.println("d");
		 *		str.append(' ');
		 *		while(str.charAt(i)==' ') 
		 **			i++;
		 *	}
		 *}
		 *System.out.println("str");
		 */
	}

}
