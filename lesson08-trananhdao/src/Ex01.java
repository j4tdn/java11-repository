import java.util.Scanner;

public class Ex01 {
	 public static void main(String[] args) {
	        //   System.out.println(ex01());
	        System.out.println("=========================");
	        ex02();
	        System.out.println("=========================");
	        ex03();

	    }

	    private static String ex01() {
	        Scanner ip = new Scanner(System.in);
	        System.out.println("mời nhập chuỗi có dấu: ");
	        String s = ip.nextLine();
	        while (true) {
	            if (!s.matches(".*[ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨ"
	                    + "ẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉị"
	                    + "ọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+$")) {
	                System.out.println("bạn nhập không đúng theo yêu cầu( mời nhập lại: )");
	                s = ip.nextLine();

	            }

	        }

	    }

	    private static void ex02() {
	        String s = "hello world";
	        for (int i = 0; i < s.length(); i++) {
	            System.out.println(s.charAt(i));
	        }
	    }

	    private static void ex03() {
	        String s = "what a wonderful day";
	       String[] strings = s.split(" ");

			for(String s1 : strings) {
			      String s2 = new StringBuffer(s1).reverse().toString();
			      System.out.print(s2 + " ");
			     }

	    }

}
