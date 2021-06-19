package immutable;

import java.util.Iterator;

public class Ex03 {
	public static void main(String[] args) {
		String s1 = "Re2cy5cle Vi7ew";
		
		System.out.println("length: " + s1.length());
		System.out.println("charAt3: " + s1.charAt(3));
		
		//loop
	
		for (int i = 0; i < s1.length(); i++) {
			char tmp = s1.charAt(i);
			if(Character.isDigit(tmp)) {  //neu tmp truyen vao la so thi in ra
			System.out.println(tmp);
		}
		
		}
		//noi chuoi
		s1 = s1.concat(" - Layout"); // dung toan tu (+) hoac ham concatenate	
		System.out.println("s1: " + s1);
		
		//tim vi tri xuat hien dau tien cua chu "y" trong s1
		System.out.println("s1: " + s1);
		
		int indexY = s1.indexOf("y");
		int lastY = s1.lastIndexOf("y");
		
		System.out.println("first 'y' position: " + indexY);
		System.out.println("last 'y' position: " + lastY);
		
		System.out.println("sub: " + s1.substring(indexY,lastY+1)); //cat chuoi
			
	}
	
}