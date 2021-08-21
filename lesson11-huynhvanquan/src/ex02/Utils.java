package ex02;

import java.util.ArrayList;

public class Utils {
	private Utils() {
	}
	
	public static void print(ArrayList<CD> cdList) {
		for(CD item : cdList) {
			System.out.println(item);
		}
	}
	
}
