package ex02;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Input: ");
		String text = sc.nextLine();
		try {
			if(isValueForm(text)) {
				test(text);
			}
		} catch (Exception e) {
			System.out.println("Wrong name form!");
		}
		
	}
	public static void test(String text) {
		if(text == null) {
			System.out.println("Input null");
			return;
		}
		for(String i : text.split("\\s+")) {
			System.out.print(i.substring(0,1).toUpperCase() + i.substring(1,i.length()).toLowerCase()+" ");
		}
	}
	private static Boolean isValueForm(String text) throws Exception {
		if(!text.matches("A-Za-z")) {
			throw new Exception();
		}
		else return true;
	}
	
}
