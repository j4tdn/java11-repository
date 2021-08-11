package bt02;

import java.util.HashSet;
import java.util.Set;

public class Bt02 {
	public static void main(String[] args) {
		Set<CD> cd = new HashSet<CD>();
		cd.add(new CD(1, "MP3", "Ho Quang Hieu", 13, 45));
		cd.add(new CD(2, "MP4", "No Phuoc Thinh", 16, 75));
		cd.add(new CD(3, "MP4", "Son Tung", 19, 47));
		cd.add(new CD(4, "MP3", "Lou Hoang", 11, 44));
		cd.add(new CD(5, "MP3", "Adam", 12, 40));

		// CD need add
		CD c = new CD(2, "MP3", "Ho Quang Hieu ", 13, 45);
		if(cd.contains(c))
		
		printf(cd);
		System.out.println(cd.size());
	}

	
	
	
	
	
	public static void printf(Set<?> cd) {
		for (var element : cd) {
			System.out.println(element);
		}
		System.out.println();
	}
}
