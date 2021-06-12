package exercises;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import model.Student;

public class Ex02 {
	public static final String DATE_FORMAT = "dd/MM/yyyy";
	public static final Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		String id = inputId();
		String name = inputName();
	String password = inputPassword();
		String birthday = inputBirthday();
		
		Student student = new Student(id, name, password, birthday);
		System.out.println(student.toString());
		System.out.println("You registered successfully!");
	}
	
	public static String inputId() {
		do {
			try {
				System.out.print("Enter ID like 'bkit-xxx' (x is a number): ");
				String id = sc.nextLine();
				if (id.matches("^(bkit-)[0-9]{3}$")) {
					return id;
				} else {
					throw new RuntimeException("Length isn't equal to 8 characters or wrong format!");
				}				
			}
			catch(RuntimeException e) {		
				System.out.println(e);
			}
		} while (true);
	}
	
	public static String inputName() {
		do {
			try {
				System.out.print("Enter name: ");
				String name = sc.nextLine();
				
				if (name.length() < 6) {
					throw new RuntimeException("Name must be 6 characters at least");
				} else if (name.matches(".*[\\d]+.*")) {
					System.out.println("name contain number");
					throw new RuntimeException("Name can not contain the numbers"); 
				} else if (name.matches(".*[!@#$%^&*()~`<>{}]+.*")) {
					System.out.println("name contain special characters");
					throw new RuntimeException("Name can not contain the special characters"); 
				} else return name;
			} catch (RuntimeException e) {		
				System.out.println(e);
			}			 
		} while (true);
	}
	
	public static String inputPassword() {
		do {
			try {
				System.out.print("Enter password: ");
				String password = sc.nextLine();
				System.out.println(password);
				if (password.length() < 8 || password.length() > 63) {
					throw new RuntimeException("Password must have length (8-63) characters!");
				} else if (!password.matches(".*[!@#$%^&*]+.*")) {
					throw new RuntimeException("Password must contain at least one special character!"); 
				} else if (!password.matches(".*[A-Z]+.*")) {
					throw new RuntimeException("Password must contain at least one uppercase character!"); 
				} else return password;
			} catch (RuntimeException e) {	
				System.out.println(e);
			}			 
		} while (true);
	}
	
	public static String inputBirthday() {
		DateFormat df = new SimpleDateFormat(DATE_FORMAT);
		
		do {
			try {
				System.out.print("Enter birhday (dd/MM/yyyy): ");
				String birthday = sc.nextLine();
				System.out.println(birthday);
				DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				Date date = format.parse(birthday);				
				
				if (date == null) {
		            throw new RuntimeException("Date cannot be null!!");
		        }
				
				String[] days = birthday.split("/");	
				Calendar c = Calendar.getInstance();
				c.setTime(date);

				if (Integer.parseInt(days[0]) == c.get(Calendar.DAY_OF_MONTH) 
						&& (Integer.parseInt(days[1]) - 1) == c.get(Calendar.MONTH)
						&& Integer.parseInt(days[2]) == c.get(Calendar.YEAR)) {
					return birthday;					
				}				
				throw new RuntimeException("Date is invalid!");					
			} catch (RuntimeException e) {
				System.out.println(e);
			} catch (ParseException e) {
				System.out.println(e);
			}
			
		} while (true);
	}
}