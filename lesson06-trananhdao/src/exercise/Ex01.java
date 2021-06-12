package exercise;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args)  {
        int a,b;
        Scanner ip = new Scanner(System.in);
    
        while(true){
            try {
                System.out.println("enter number a: ");
                a = Integer.parseInt(ip.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
        while(true){
            try {
                System.out.println("enter number b: ");
                b = Integer.parseInt(ip.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            System.out.println("a/b= "+ equation(a, b));
            
        } catch ( MyException e) {
            System.out.println(e.getMessage());
        }
    }
    private static int equation(int a, int b) throws MyException {
		
		if(b==0) {
			throw new MyException("Please enter a non-zero value");
			
		}
		System.out.println("return a/b");
		return a / b;

	}
}
