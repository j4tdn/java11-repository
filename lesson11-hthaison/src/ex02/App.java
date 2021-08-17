package ex02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import exception.ExceptionID;
import utils.ListUtils;


public class App {
	private static List<DishCD> list = new ArrayList<DishCD>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int mode = 1;
		while(mode != 0) {
			System.out.println("Mode: ");
			mode = sc.nextInt();
			switch(mode) {
			case 1:
				try {
				Add();
				}
				catch(ExceptionID e) {
					System.out.println("ID da ton tai ");
				}
				break;
				
			case 2:
				ListUtils.printfList(list);
				break;
			case 3:
				System.out.println("==== So Luong Cd===");
				int count = 0;
				for(DishCD i : list) {
					count ++;
				}
				System.out.println(count);
				break;
			case 4:
				System.out.println("=== Tổng Giá===");
				System.out.println(sumPrice());
				break;
			case 5:
				System.out.println("Sort bt price");
				desByPrice();
				ListUtils.printfList(list);
				break;
			case 6:
				System.out.println("Sort by Loai");
				Comparator<DishCD> c2 = Comparator.nullsFirst(Comparator.comparing(DishCD::getLoaiCD));
				sort(c2);
				ListUtils.printfList(list);
				break;
				
			}
		}
		
	}
	private static void Add() throws ExceptionID {
		try (Scanner sc = new Scanner(System.in)) {
			DishCD cd = new DishCD();
			System.out.println("Mã CD");
			int id = Integer.parseInt(sc.nextLine());
			for(DishCD i : list) {
				if(id == i.getMaCD()) {
					throw new ExceptionID("Ma CD da ton tai, Nhap Laij");
				}
				else {
					cd.setMaCD(id);
				}
			}

			System.out.println("Loại CD");
			cd.setLoaiCD(sc.nextLine());
			
			System.out.println("Tên Ca Sỹ");
			cd.setSinger(sc.nextLine());
			
			System.out.println("Số Bài Hát");
			cd.setNumber(sc.nextInt());
			
			System.out.println("Giá");
			cd.setPrice(sc.nextDouble());
			
			list.add(cd);
		}
	}
	private static double sumPrice() {
		double sum = 0;
		for(DishCD i : list) {
			sum += i.getPrice();
		}
		return sum;
	}
	private static void desByPrice() {
		Comparator<DishCD> compartor =  (o1,o2) -> Double.compare(o1.getPrice(), o2.getPrice());
			list.sort(compartor);
	}
	private static void sort(Comparator<DishCD> comparator) {
		Collections.sort(list, comparator);
		
	}
	
}
