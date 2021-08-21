package ex02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class App {
	public static void main(String[] args) {
		List<CD> cdList = new ArrayList<CD>(getCD());
		menu((ArrayList<CD>)cdList);

	}

	// Q1: Add CD, return success/fail
	private static boolean addCD(ArrayList<CD> cdList, CD newCD) {
		for (CD item : cdList) {
			if (item.getId() == newCD.getId()) {
				return false;
			}
		}
		cdList.add(newCD);
		return true;
	}

	// Q2: Calc amount of cdList
	private static int getSize(ArrayList<CD> cdList) {
		return cdList.size();
	}

	// Q3: Calc sum price of all cds
	private static double priceOfAllCD(ArrayList<CD> cdList) {
		double sum = 0;
		for (CD item : cdList) {
			sum += item.getPrice();
		}
		return sum;
	}

	// Q4: Sort list descending by price
	private static void sortListByPrice(ArrayList<CD> cdList, SortType sortType) {
		if (sortType == SortType.ASCENDING) {
			// W1: Sorting with comparator
			Comparator<CD> c1 = new Comparator<CD>() {
				@Override
				public int compare(CD cd1, CD cd2) {
					return Double.compare(cd1.getPrice(), cd2.getPrice());
				}
			};

			// W2: Sorting with comparator and lambda
			Comparator<CD> c2 = (cd1, cd2) -> Double.compare(cd1.getPrice(), cd2.getPrice());

			// W3: Sorting with Comparator.comparing and Function interface
			Comparator<CD> c3 = Comparator.comparing(new Function<CD, Double>() {
				@Override
				public Double apply(CD cd) {
					return cd.getPrice();
				}
			});

			// W4: Sorting using Comparator.comparing with lambda
			Comparator<CD> c4 = Comparator.comparing(cd -> cd.getPrice());

			// W5: Sorting with Collections and :: (colon operator)
			Collections.sort(cdList, Comparator.comparing(CD::getPrice));
		}

		if (sortType == SortType.DESCENDING) {
			// W1: Sorting with comprator
			Comparator<CD> c1 = new Comparator<CD>() {
				@Override
				public int compare(CD cd1, CD cd2) {
					return Double.compare(cd2.getPrice(), cd1.getPrice());
				}

			};

			// W2: Sorting with comparator and lambda
			Comparator<CD> c2 = (cd1, cd2) -> Double.compare(cd2.getPrice(), cd1.getPrice());

			// W3: Sorting with Comparator.comparing and Function interace
			Comparator<CD> c3 = Comparator.comparing(new Function<CD, Double>() {
				@Override
				public Double apply(CD cd) {
					return cd.getPrice();
				}
			});

			// W4: Sorting with Comparator.comparing and lambda
			Comparator<CD> c4 = Comparator.comparing(cd -> cd.getPrice());

			// W5: Sorting with Collection and :: (colon operator)
			Collections.sort(cdList, Comparator.comparing(CD::getPrice, Comparator.reverseOrder()));
		}
	}

	// Q5: Sorting with Category
	private static void sortListByCategory(ArrayList<CD> cdList, SortType sortType) {
		if (sortType == SortType.ASCENDING) {

			// W1: Sorting with Comparator
			Comparator<CD> c1 = new Comparator<CD>() {
				@Override
				public int compare(CD cd1, CD cd2) {
					return cd1.getCategory().compareToIgnoreCase(cd2.getCategory());
				}

			};

			// W2: Sorting with Comparator and Lambda
			Comparator<CD> c2 = (cd1, cd2) -> cd1.getCategory().compareToIgnoreCase(cd2.getCategory());

			// W3: Sorting with Comparator.comparing and Function Interface
			Comparator<CD> c3 = Comparator.comparing(new Function<CD, String>() {
				@Override
				public String apply(CD cd) {
					return cd.getCategory();
				}
			});

			// W4: Sorting with Comparator and :: (colon operator)
			Comparator<CD> c4 = Comparator.comparing(CD::getCategory);

			// W5: Sorting with Collections and :: (colon operator)
			Collections.sort(cdList, Comparator.comparing(CD::getCategory));
		}

		if (sortType == SortType.DESCENDING) {
			// W1: Sorting with Comparator
			Comparator<CD> c1 = new Comparator<CD>() {
				@Override
				public int compare(CD cd1, CD cd2) {
					return cd2.getCategory().compareTo(cd1.getCategory());
				}
			};

			// W2: Sorting with Comparator and lambda
			Comparator<CD> c2 = (cd1, cd2) -> cd2.getCategory().compareTo(cd1.getCategory());

			// W3: Sorting with Comparator.comparing and Function collection
			Comparator<CD> c3 = Comparator.comparing(new Function<CD, String>() {
				@Override
				public String apply(CD cd) {
					return cd.getCategory();
				}
			});

			// W4: Sorting with Comparator.comparing and :: (colon operator)
			Comparator<CD> c4 = Comparator.comparing(CD::getCategory);

			// W5: Sorting with Collections and :: (colon operator)
			Collections.sort(cdList, Comparator.comparing(CD::getCategory, Comparator.reverseOrder()));
		}

	}
	
	private static CD inputCD() {
		CD cd = new CD();
		Scanner sc = new Scanner(System.in);
		System.out.println("=== Enter CD ===");
		System.out.println("Enter id: ");
		cd.setId(sc.nextInt());
		System.out.println("Enter category: ");
		cd.setCategory(sc.next());
		System.out.println("Enter singer: ");
		cd.setSinger(sc.next());
		System.out.println("Enter song number: ");
		cd.setSongNumber(sc.nextInt());
		System.out.println("Enter price: ");
		cd.setPrice(sc.nextDouble());
		return cd;
	}

	private static void menu(ArrayList<CD> cdList) {
		int choice;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("===== MENU List =====");
			System.out.println("1. Add CD");
			System.out.println("2. Count CD");
			System.out.println("3. Count total prices");
			System.out.println("4. Sort descending by price");
			System.out.println("5. Sort ascending by category");
			System.out.println("6. Exit");
			System.out.println("-----------------------------");
			System.out.println("Enter option: ");
			choice = sc.nextInt();
			switch(choice) {
			case 1: 
				if (addCD(cdList, inputCD())) {
					System.out.println("Add successfully!");
					break;
				}
				System.out.println("Add failure");
				break;
			case 2: 
				System.out.println("Size of cd list: " + getSize(cdList));
				break;
			case 3: 
				System.out.println("Total money: " + priceOfAllCD(cdList));
				break;
			case 4: 
				System.out.println("Sorting CD list descending by price:");
				sortListByPrice(cdList, SortType.ASCENDING);
				Utils.print(cdList);
				break;
			case 5: 
				System.out.println("Sorting CD list by ascending by category: ");
				sortListByCategory(cdList, SortType.DESCENDING);
				Utils.print(cdList);
				break;
			case 6: 
				System.exit(0);
				break;
			default:
				System.out.println("Don't have this options! Please enter again.");
			}
		}while(true);
	}
	
	private static List<CD> getCD() {
		return Arrays.asList(
			new CD(1,  "CD-Text",   "Nguyen Phuc", 20, 22000),
			new CD(2,  "CD-ROM",    "Tran Nam",    32, 33000),
			new CD(3,  "CD-Text",   "Doan Du",     18, 25000),
			new CD(4,  "CD-ROM",    "Phan Dang",   10, 29000),
			new CD(5,  "CD-Bridge", "Tran Tien",   25, 49000),
			new CD(6,  "CD-ROM",    "Hoang Sang",  17, 56000),
			new CD(7,  "CD-ROM",    "Le Thien",    15, 77000),
			new CD(8,  "CD-ROM",    "Nguyen Phuc", 50, 84000),
			new CD(9,  "CD-Bidge",  "Nguyen Sinh", 44, 52000),
			new CD(10, "CD-Text",   "Tran Dai",    36, 18000),
			new CD(11, "CD-Bridge", "Phan Si",     41, 99000),
			new CD(12, "CD-Text",   "Nguyen Phuc", 47, 103000));
	}
}
