package ex01;

import java.util.ArrayList;
import java.util.List;

public class CDList {
	private CDList() {
	}
	
	public static List<CD> getAll(){
		List<CD> getCDs = new ArrayList<>();
		
		getCDs.add(new CD(1, "pop", "Adele", 12, 150d));
		getCDs.add(new CD(2, "country", "Taylor Swift", 10, 180d));
		getCDs.add(new CD(3, "rock", "Imagine Dragon", 11, 130d));
		getCDs.add(new CD(4, "pop", "Ed sheeran", 12, 150d));
		getCDs.add(new CD(5, "edm", "Allen Walker", 12, 150d));
				
		return getCDs;
	}
}
