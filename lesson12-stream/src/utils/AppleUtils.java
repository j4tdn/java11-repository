package utils;

import java.util.Arrays;
import java.util.List;

import bean.Apple;

public class AppleUtils {
	
	private AppleUtils() {
		
	}
	
	public static List<Apple> getAll() {
		return Arrays.asList(
				new Apple(1, "green", 400, "VietNam"),	
				new Apple(16, "green", 500, "VietNam"),	
				new Apple(22, "red", 300, "Lao"),	
				new Apple(4, "yellow", 400, "Thailand"),	
				new Apple(17, "red", 600, "VietNam"),	
				new Apple(6, "green", 100, "Thailand")	
		);
	}
}