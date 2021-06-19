package immutable;

import java.util.Iterator;

public class Ex03 {
	public static void main(String[] args) {
		String s1 = "Rec32ycle Vi5ew";
		
		// length
		System.out.println("length: " + s1.length());
		System.out.println("charAt3: " + s1.charAt(3));
		
		for(int i = 0; i < s1.length(); i++) {
			System.out.println(s1.charAt(i));
		}
		
		System.out.println("=========================");
		for(int i = 0; i < s1.length(); i++) {
			char  tmp = s1.charAt(i);
			if(Character.isDigit(tmp))
			System.out.println(tmp);
		}
		
		//s1 = s1 + "_Layout"; // trỏ sang vung nho moi
		
		s1 = s1.concat("_Layout");
		System.out.println("s1: " +s1);
		System.out.println("=================================");
		// tim vi tri dau tien cua y
		
		int index1 = s1.indexOf('y');
		int index2 = s1.lastIndexOf('y');
		System.out.println("first 'y' position: " + index1);
		System.out.println("first 'y' position: " + index2);
		System.out.println("sub: "+ s1.substring(index1, index2+1));
		
	}

}
