package exercise;

import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        String email;
        while(true){
            
            try {
                System.out.println("Enter your Email address: ");
                email = ip.nextLine();
                if (EmailException(email) == true) {
                    System.out.println("Valid email");
                    break;
                }
                
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private static boolean EmailException(String email) throws MyException{
        if((email.endsWith("@")||email.startsWith("@"))){
            throw new MyException(" Invalid email!!! "
                    + "Don't put @ in the first and last");
        }
        if(!(email.contains("@"))){
            throw new MyException(" Invalid email"
                    + "there is no @ character in gmail");
        }
        if(!(email.contains(".com"))){
            throw new MyException("Invalid email");
        }
        return true;
    }
}
