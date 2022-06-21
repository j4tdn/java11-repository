package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import bean.Student;

public class MockData {
	private MockData() {
		
	}
	
	// Load data from DAO - Database
	
	public static List<Student> getStudents() {
		return new ArrayList<Student>(Arrays.asList(
		   new Student("102", "Adam Tone", 1934, "Vietnam", new String[] {"Unix", "Windows"}, "BKIT-11"),
		   new Student("130", "Dummy", 1924,  "Germany", new String[] {"Windows"}, "BKIT-11"),
		   new Student("174", "John Terry", 1982,  "Russia", new String[] {"Unix", "Linux"}, "BKIT-11")
		));
	}
	
	public static String[] getCountries() {
		return new String[] {
				"Vietnam", "France", "Germany", "Russia"	
		};
	}
	
	public static String[] getOses() {
		return new String[] {
				"Unix", "Mac OS", "Windows", "Linux"	
		};
	}
}
