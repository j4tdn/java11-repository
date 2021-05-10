package ex02;

import java.math.BigDecimal;
import java.util.Scanner;

/*
 * Vehicle Management
 */
public class AppEx02 {

	private static Vehicle[] listVehicle = new Vehicle[1000000];
	private static int indexListVehicle = 0;
	private static Scanner ip = new Scanner(System.in);
	private static int choiceInputMenu = 0;

	public static void main(String[] args) {
		do {
			printMenuAndGetChoice();
			switch (choiceInputMenu) {
			case 1:
				importNewVehicle();
				break;
			case 2:
				exportListRegFeeVeheicle();
				break;
			case 3:
				exit();
				return;
			default:
				requireTypingAgain();
				break;
			}
		} while (true);
	}

	private static void exit() {
		ip.close();
		System.out.println("Exit.");
	}

	private static void printMenuAndGetChoice() {
		// Print Menu
		System.out.println("1. Nhap thong tin xe");
		System.out.println("2. Xuat bang ke khai tien thue truoc ba");
		System.out.println("3. Thoat");

		// Get choice
		try {
			choiceInputMenu = Integer.parseInt(ip.nextLine());
		} catch (Exception e) {
			choiceInputMenu = 0;
		}
	}

	private static void requireTypingAgain() {
		// Require typing range 1-3
		System.out.println("\nNhap lai");
	}

	private static void exportListRegFeeVeheicle() {
		System.out.println(String.format("%-30s %-20s %-15s %-20s %-15s", "Ten chu xe", "Loai xe", "Dung tich",
				"Tri gia", "Thue phai nop"));
		for (int i = 0; i < 103; i++) {
			System.out.print("-");
		}
		System.out.println();
		for (int i = 0; i < indexListVehicle; i++) {
			System.out.println(listVehicle[i]);
		}
		ip.nextLine(); // pause screen
	}

	private static void importNewVehicle() {
		// Get vehicle's value from typing
		System.out.print("Nhap ten chu xe: ");
		String ownerName = ip.nextLine();
		System.out.print("Nhap loai xe: ");
		String model = ip.nextLine();
		System.out.print("Nhap dung tich xe: ");
		int volCylinder = ip.nextInt();
		System.out.print("Nhap gia xe: ");
		BigDecimal price = ip.nextBigDecimal();
		ip.nextLine(); // clear enter characters

		// Add a vehicle to list
		listVehicle[indexListVehicle++] = new Vehicle(ownerName, model, volCylinder, price);
	}

}
