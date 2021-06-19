package immutable;

import utils.JvmUtils;

public class Ex03 {
	public static void main(String[] args) {
		String s1 = "Re2cy5cle View";
		
		JvmUtils.hash("s1", s1);


		System.out.println("length: " + s1.length());
		System.out.println("chartAt3: " + s1.charAt(3));

		for (int i = 0; i < s1.length(); i++) {
			char tmp = s1.charAt(i);
			if(Character.isDigit(tmp))
			System.out.print(tmp + " ");
		}
		
		s1 = s1.concat("- Layout");
		System.out.println("s1: " +s1);
		
		JvmUtils.hash("s1", s1);

		int index1 = s1.indexOf('y');
		int index2 = s1.lastIndexOf('y');
		System.out.println("first 'y' position: " + index1);
		System.out.println("first 'y' position: " + index2);
		System.out.println("sub: "+ s1.substring(index1, index2+1));


	}
	

}
