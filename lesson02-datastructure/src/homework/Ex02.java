package homework;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Ex02 {
	private static final String User ="admin";
	private static final String pass ="259";
	private static Random rd = new Random();
	
	public static void main(String[] args) {
		String username= "admin";
		String password =null;
		int noe =1;
		int i=0;
		ArrayList<String> a= new ArrayList<String>();
		
		String [] wp	 = new String[1000];
		do
		{
			sleep(269);
			password = ""+rd.nextInt(10)+rd.nextInt(10)+rd.nextInt(10);
			if(contains(wp,password,i))
			{
				continue;
			}
			wp[i++] = password;
			System.out.print(password+ "  ");
			if(noe%13==0)
			{
				System.out.println();
			}
			noe++;
		}while(!login(username,password));
		System.out.println("=======Login SuccessFull !!!");
		System.out.println("Username "+username);
		System.out.println("Password "+password);
		
		System.out.println("NOE: " +noe);
	}
	private static boolean contains(String[] wp, String password,int nonNullSize) {
		// TODO Auto-generated method stub
		for(int i=0;i<nonNullSize;i++)
		{
			if(wp[i].equals(password))
			{
				return true;
			}
		}
		return false;
	}
	private static boolean login(String username, String password) {
		// TODO Auto-generated method stub
		return username.equals(User)&&password.equals(pass);
	}
	private static void sleep(int mls)
	{
		try {
			TimeUnit.MILLISECONDS.sleep(mls);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
