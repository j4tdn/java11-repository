package ex01;

import java.util.ArrayList;
import java.util.List;

import utils.CollectionUtils;

public class App {
	public static void main(String[] args) {
		List<CD> cds = CDList.getAll();
		
		System.out.println("===add CD===");
		addCD(cds, new CD(6, "rap", "den vau", 8, 100d));
		CollectionUtils.printf(cds);
		
		System.out.println("===total cd===");
		totalCD(cds);
		
		System.out.println("===total price===");
		System.out.println(totalPrice(cds));
		
		System.out.println("===sort by price===");
		
	}
	
	
	private static List<CD> addCD(List<CD> cds, CD addCD){
		List<CD> disk = new ArrayList<>();
		
		if (!cds.contains(addCD)) {
			cds.add(addCD);
		}
		
		return disk;
	}
	
	
	private static void totalCD (List<CD> cds) {
		System.out.println("total CD in list: " + cds.size());
	}
	
	
	private static double totalPrice(List<CD> cds) {
		double prices = 0d;
		
		for (CD cd : cds) {
			if (cd != null) {
				prices = prices + cd.getPrice();
			}
		}
		
		return prices;
	}
	
}
