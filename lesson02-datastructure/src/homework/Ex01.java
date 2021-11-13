package homework;

import java.util.Scanner;

public class Ex01 {
public static void main(String[] args) {
	Scanner ip= new Scanner(System.in);
	int count	=0;
	String text=null;
	do {
		System.out.println("Enter a valid number:");
		text =ip.nextLine();
		if(isvalidNumberpt(text))
		{
			System.out.println("number: "+text);
			return;
		}
		if(count ==3)
		{
			System.out.println("wrong entering number exceed 3 time");
			return;
		}
	}while(true);	
}
private static boolean isvalidNumber(String text)
{
	for(int i=0;i<text.length();i++)
	{
		char tmp = text.charAt(i);
		if(!Character.isDigit(tmp))
		{
			return false;
		}
	}
	return true;
}
private static boolean isvalidNumberpt(String text) {
	// TODO Auto-generated method stub
	String regex ="\\d+";
	return text.matches(regex);
}
}
