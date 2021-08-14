package ex02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import utils.CDUtils;

public class App {
	public static void main(String[] args) {
		CDShop cd1 = new CDShop(111, "Kpop", "BigBang", 6, 4.5d);
		CDShop cd2 = new CDShop(112, "Vpop", "Mỹ Tâm", 4, 2.1d);
		CDShop cd3 = new CDShop(113, "Pop", "Michael Jackson", 15, 3d);
		CDShop cd4 = new CDShop(114, "Dance", "No", 8, 5d);
		CDShop cd5 = new CDShop(115, "EDM", "Alan Walker", 5, 1.2d);
		List<CDShop> cd = new ArrayList<>();		
		cd.add(cd1);
		cd.add(cd2);
		cd.add(cd3);
		cd.add(cd4);
		cd.add(cd5);
		
		System.out.println("Nhập vào 1 - 5" + 
				"\n1. Thêm 1 CD vào danh sách." + 
				"\n2. Tính số lượng CD có trong danh sách." + 
				"\n3. Tình tổng giá thành của các CD." + 
				"\n4. Sắp xếp danh sách giảm dần theo giá thành." + 
				"\n5. Sắp xếp danh sách tăng dần theo tựa CD.");
		while(true) {
		try {
			System.out.print("Enter: ");
			switch (enter()) {
			case 1: {
				while(true) {
					try {
						cd.add(addCD(cd));
						System.out.println("Nhập thành công!");
						CDUtils.prinf(cd);
						break;
					} catch (CDException e) {
						System.out.println(e.getMessage());
					}
				}
				break;
			}
			case 2: System.out.println("Số lượng CD có trong danh sách: " + amountCD(cd)); break;
			case 3: System.out.println("Tổng tiền: " + totalPrice(cd)); break;
			case 4: CDUtils.prinf(decreasePrice(cd)); break;
			case 5: CDUtils.prinf(ascendingPrice(cd)); break;
			}
		} catch (CDException e) {
			System.out.println(e.getMessage());
		}
	}
	}
	private static CDShop addCD(List<CDShop> albums) throws CDException{
		CDShop cd = new CDShop();
		Scanner ip = new Scanner(System.in);
		System.out.print("Nhập mã CD: ");
		int id = ip.nextInt();
		for(CDShop album: albums) {
			if(id == album.getId()) {
				throw new CDException("Trùng mã CD, mời nhập lại!");
			}
		}
		
		cd.setId(id);
		ip.nextLine();
		System.out.print("Nhập loại CD: ");
		cd.setType(ip.nextLine());
		System.out.print("Nhập tên ca sĩ: ");
		cd.setSinger(ip.nextLine());
		System.out.print("Nhập số bài hát: ");
		cd.setSongNumber(ip.nextInt());
		System.out.print("Nhập giá: ");
		cd.setPrice(ip.nextDouble());
		return cd;
	}
	
	private static int amountCD(List<CDShop> albums) {
		int count = 0;
		for(CDShop album: albums) {
			count++;
		}
		return count;
	}
	
	private static double totalPrice(List<CDShop> albums) {
		double total = 0;
		for(CDShop album: albums) {
			total += album.getPrice();
		}
		return total;
	}
	
	private static List<CDShop> decreasePrice(List<CDShop> albums){
		Comparator<CDShop> comparator = new Comparator<CDShop>() {

			@Override
			public int compare(CDShop d1, CDShop d2) {
				return Double.compare(d2.getPrice(), d1.getPrice());
			}
		};

		albums.sort(comparator);
		return albums;
	}
	
	private static List<CDShop> ascendingPrice(List<CDShop> albums){
		Comparator<CDShop> comparator = new Comparator<CDShop>() {
			
			@Override
			public int compare(CDShop o1, CDShop o2) {
				return o1.getType().compareTo(o2.getType());
			}
		};
		albums.sort(comparator);
		return albums;
	}
	
	private static int enter() throws CDException {
		Scanner ip = new Scanner(System.in);
		int key = ip.nextInt();
		if(key < 1 || key > 5) {
			throw new CDException("Nhập số từ 1 đến 5!");
		}
		return key;
	}
}
