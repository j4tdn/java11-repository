package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import bean.Student;

public class MockData {
	
	private MockData() {
	}
	
	// Load data from DAO - Databases
	
	public static List<Student> getStudents(){
		return new ArrayList<Student>(Arrays.asList(
				new Student("102", "Adam Tone", 1934, "VietNam", new String[] {"Unix", "Window"}, "BKIT-11"),
				new Student("130", "Dummy", 1924, "Germany", new String[] {"Window"}, "BKIT-11"),
				new Student("102", "John Terry", 1982, "Russia", new String[] {"Unix", "Linux"}, "BKIT-11")
	    ));
	}
	
	public static String[] getCountries() {
		return new String[] {
				"VietNam", "France", "Germany", "Russia"
		};
	}
	
	public static String[] getOses() {
		return new String[] {
				"Unix", "Mac OS", "Window", "Linux"
		};
	}

}
