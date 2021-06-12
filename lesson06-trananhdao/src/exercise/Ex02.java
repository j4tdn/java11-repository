package exercise;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {

        Scanner ip = new Scanner(System.in);
        String pass;
        while (true) {
            try {
                System.out.println("create a pasword ");
                pass = ip.nextLine();
                if (checkpassword(pass) == true) {
                    System.out.println("your password is set SUCCESSFULLY");
                    break;
                }
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }

        }

    }

    private static boolean checkpassword(String pass) throws MyException {
        if (pass.length() < 8) {
            throw new MyException("At least 8 characters");
        }
        if (pass.length() > 256) {
            throw new MyException("At most 256 characters");
        }
        if (!pass.matches(".*[a-z].*")) {
            throw new MyException("At least 1 lowercase alphabetic character(a,b,c,..)");
        }
        if (!pass.matches(".*[A-Z].*")) {
            throw new MyException("At least 1 uppercase alphabetic character(A,B,C,..)");
        }
        if (!pass.matches(".*[#?!@$%^&*-].*")) {
            throw new MyException("At least 1 special character");
        }

        if (!pass.matches(".*?[0-9].*")) {
            throw new MyException("At least 1 number");
        }

        return true;
    }

}
