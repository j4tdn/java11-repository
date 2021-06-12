package exercises;

public class Ex04 {
	public static void main(String[] args) {
		int num1 = 1;
		int num2 = 45;
		int num3 = 55;
		int num4 = 123;
		int num5 = 33;
		int num6 = 11;
		int num7 = 15;
		int num8 = 456;
		int num9 = 990;
		
		System.out.println(readHundreds(num1));
		System.out.println(readHundreds(num2));
		System.out.println(readHundreds(num3));
		System.out.println(readHundreds(num4));
		System.out.println(readHundreds(num5));
		System.out.println(readHundreds(num6));	
		System.out.println(readHundreds(num7));	
		System.out.println(readHundreds(num8));
		System.out.println(readHundreds(num9));	
	}
	
	public static String readRowUnit(int num) {
		String s = "";
		
		if (num == 1) s =  "một";
		if (num == 2) s =  "hai";
		if (num == 3) s =  "ba";
		if (num == 4) s =  "bốn || tư";
		if (num == 5) s =  "năm";
		if (num == 6) s =  "sáu";
		if (num == 7) s =  "bảy";
		if (num == 8) s =  "tám";
		if (num == 9) s =  "chín";
		
		return s;
	}
	
	public static String readTens(int num) {
		int mod = num % 10;
		num /= 10;
		String s = "";
		
		
		if (num == 1) {
			s =  "mười";
			if (mod == 1) return s += " " + "một";
		}
		if (num == 2) s =  "hai mươi";
		if (num == 3) s =  "ba mươi";
		if (num == 4) s =  "bốn mươi";
		if (num == 5) s =  "năm mươi";
		if (num == 6) s =  "sáu mươi";
		if (num == 7) s =  "bảy mươi";
		if (num == 8) s =  "tám mươi";
		if (num == 9) s =  "chín mươi";	
		
		
		if (num > 1 && mod == 1) return s += " " + "mốt";
		if (mod == 5) return s += " " + "lăm"; 
		
		return s + " " + readRowUnit(mod);
	}

	public static String readHundreds(int num) {
		int mod = num % 100;
		num /= 100;
		
		String s = "";
		
		if (num == 1) s = "một trăm";
		if (num == 2) s = "hai trăm";
		if (num == 3) s = "ba trăm";
		if (num == 4) s = "bốn trăm";
		if (num == 5) s = "năm trăm";
		if (num == 6) s = "sáu trăm";
		if (num == 7) s = "bảy trăm";
		if (num == 8) s = "tám trăm";
		if (num == 9) s = "chín trăm";		
		if (num > 0 && mod < 10) s += " " + "linh || lẻ";
		
		return (s + " " + readTens(mod)).trim();
	}
}