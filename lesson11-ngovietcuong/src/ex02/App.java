package ex02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import utils.CDUtils;

public class App {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		List<CD> cds = CDUtils.getAll();

		List<CD> comple = Arrays.asList(new CD(4, "Digital Single", "Sam Smith", 22, 220),
										new CD(1, "Single", "Adele", 25, 500),
										new CD(2, "Digital Single", "Lady Gaga", 21, 400),
										new CD(8, "Digital Single", "Chris Brown", 21, 400));
		
		System.out.println("===== Functions =====");
		
		System.out.println("Enter the number 1 to add 1 CD to the list, add successfully if the CD code does not match."
				+ "\nEnter the number 2 to get  amount of CDs in the list."
				+ "\nEnter the number 3 to calculate the total cost of the CDs."
				+ "\nEnter number 4 to sort the list descending by price."
				+ "\nEnter number 5 to sort the list ascending by CD type.");
		
		System.out.println("===============");
		
		System.out.print("Enter number: ");
		int enter = ip.nextInt();
		
		switch (enter) {
		
		case 1:
			System.out.println("===== Add CD No Duplicate Id =====");
			List<CD> differentId = CDUtils.getAll();
			List<CD> difId = CDUtils.getAll();
			
			System.out.println("\n\tCurrent list");
			CDUtils.printf(differentId);
			
			System.out.println("\n\tElements To Be Added");
			CDUtils.printf(comple);
			
			System.out.println("\n\tList After Added");
			for(CD cd: comple) {
				differentId = addCD(differentId, cd);
			}
			CDUtils.printf(differentId);

			System.out.println("\n\tElements Are Not Added");
			notExist(comple, difId);
			break;
			
		case 2:
			System.out.println("===== Amount CD =====");
			System.out.println("amount CD: " + cds.size());
			break;
			
		case 3:
			System.out.println("===== Total Price =====");
			System.out.println("total price: " + totalPrice(cds));
			break;
			
		case 4:
			System.out.println("===== Sort Descending By Price =====");
			List<CD> sortDes = sortDesByPrice(cds);
			CDUtils.printf(sortDes);
			break;
			
		case 5:
			System.out.println("===== Sort Ascending By Type =====");
			List<CD> sortAsc = sortAscByType(cds);
			CDUtils.printf(sortAsc);
			break;

		default:
			System.out.println("Only numbers 1 to 5 are allowed");
			break;
		}
	}


	private static List<CD> addCD(List<CD> cds, CD cd) {		
		
		for (int i = 0; i < cds.size(); i++) {
			if (count(cds, cd.getId()) == 0) {
				cds.add(cd);
			}
		}
		return cds;
	}
	
	private static double totalPrice(List<CD> cds) {
		double sum = 0;
		for(CD cd:cds) {
			sum += cd.getPrice();
		}
		return sum;
	}
	
	private static List<CD> sortDesByPrice(List<CD> cds){
		Comparator<CD> comparator = (c1,c2) -> Double.compare(c2.getPrice(), c1.getPrice());
		cds.sort(comparator);
		return cds;
	}
	
	private static List<CD> sortAscByType(List<CD> cds){
		Comparator<CD> comparator = (c1,c2) -> c1.getType().compareTo(c2.getType());
		cds.sort(comparator);
		return cds;
	}


	private static int count(List<CD> c, int value) {
		int count = 0;
		
		for (int i = 0; i < c.size(); i++) {
			if (value == c.get(i).getId()) {
				count++;
			}
		}
		return count;
	}
	
	private static void notExist(List<CD> c, List<CD> d) {
		for(int i = 0; i < c.size(); i++) {
			for(int j = 0; j < d.size(); j++) {
				if(c.get(i).equals(d.get(j))) {
					System.out.println(c.get(i));
				}
			}
		}
	}
}
