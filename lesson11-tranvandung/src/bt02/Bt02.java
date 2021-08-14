package bt02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static java.util.Comparator.*;
import static utils.Utils.*;

public class Bt02 {
	public static void main(String[] args) {
		Set<CD> cd = new HashSet<CD>();
		cd.add(new CD(1, "MP3", "Ho Quang Hieu", 13, 45));
		cd.add(new CD(2, "MP4", "No Phuoc Thinh", 16, 75));
		cd.add(new CD(3, "MP4", "Son Tung", 19, 47));
		cd.add(new CD(4, "MP3", "Lou Hoang", 11, 44));
		cd.add(new CD(5, "MP3", "Adam", 12, 40));

		//1: CD need add
		System.out.println("1: List of CD");
		CD c1 = new CD(2, "MP3", "Ho Quang Hieu ", 13, 45);
		CD c2 = new CD(8, "MP3", "A", 13, 49);
		cd.add(c1);
		cd.add(c2);
		printfSet(cd);;
		System.out.println("============================");
		
		// 2: Total of Amount CD
		int sum = 0;
		for (CD cds : cd) {
			sum += cds.getAmount();
		}
		System.out.println("2: Total of Amount CD: " + sum);
		System.out.println("============================");

		// 3: Total of Price CD
		System.out.println("3: Total of Price CD:");
		for (CD cds : cd) {
			System.out.println(cds.getSinger() + ": " + cds.getAmount() * cds.getPrice() + "$$");
		}
		System.out.println("============================");
		
		//4: Sort Ascending Price
		List<CD> cd1 = new ArrayList<CD>(cd);
		System.out.println("4: Sort Ascending Price");
		Collections.sort((List<CD>) cd1, comparing(CD::getPrice));
		printfList(cd1);
		System.out.println("============================");
		
		//5: Sort Ascending Singer
		System.out.println("5: Sort Ascending Singer ");
		Collections.sort((List<CD>) cd1, comparing(CD::getSinger));
		printfList(cd1);
		
	}
}
