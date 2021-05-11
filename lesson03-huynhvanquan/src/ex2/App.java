package ex2;

import java.util.Scanner;

public class App {
	public static final int SPACE = 10;
	public static final int HOST_NAME_LENGTH = "Tên chủ xe".length();
	public static final int MODEL_LENGTH = "Loại xe".length();
	public static final int VOLUME_LENGTH = "Dung tích".length();
	public static final int VALUE_LENGTH = "Trị giá".length();
	public static final int TAX_LENGTH = "Thuế phải nộp".length();

	public static void main(String[] args) {
		int option;
		Scanner sc = new Scanner(System.in);
		Vehicle[] vehicles = new Vehicle[3];
		printMenu();
		option = sc.nextInt();
		process(option, vehicles);
	}

	private static void printMenu() {
		System.out.println("\nVEHICLE INFORMATION SYSTEM");
		System.out.println("==========================");
		System.out.println("Options:");
		System.out.println("1. Enter information vehicle 1, vehicle 2, vehicle 3.");
		System.out.println("2. Export the vehicle's registration tax declaration.");
		System.out.println("3. Exit.");
		System.out.print("Choose an option:");
	}

	private static void printSpace(int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(" ");
		}
	}

	private static void printTitle() {
		System.out.print("Tên chủ xe");
		printSpace(SPACE);
		System.out.print("Loại xe");
		printSpace(SPACE);
		System.out.print("Dung tích");
		printSpace(SPACE);
		System.out.print("Trị giá");
		printSpace(SPACE);
		System.out.print("Thuế phải nộp\n");
		for (int i = 0; i < SPACE * 4 + HOST_NAME_LENGTH + MODEL_LENGTH + VOLUME_LENGTH + VALUE_LENGTH
				+ TAX_LENGTH; i++) {
			System.out.print("=");
		}
	}

	private static void process(int option, Vehicle[] vehicles) {
		Scanner sc = new Scanner(System.in);
		while (option < 1 || option > 3) {
			System.out.println("Don't have this option. Please choose again: ");
			option = sc.nextInt();
		}
		while (option != 3) {
			switch (option) {
			case 1:
				for (int i = 0; i < vehicles.length; i++) {
					vehicles[i] = new Vehicle();
					System.out.println("ENTER VEHICLE " + (i + 1));
					System.out.print("Enter host name: ");
					vehicles[i].setHostName(sc.nextLine());
					System.out.print("Enter model: ");
					vehicles[i].setModel(sc.nextLine());
					System.out.print("Enter volume: ");
					vehicles[i].setVolume(sc.nextInt());
					System.out.print("Enter value: ");
					vehicles[i].setValue(sc.nextDouble());
					sc.nextLine();
					if (vehicles[i].getVolume() < 100) {
						vehicles[i].setTax(vehicles[i].getValue() / 100);
					}
					if (100 <= vehicles[i].getVolume() && vehicles[i].getVolume() <= 200) {
						vehicles[i].setTax(vehicles[i].getValue() * 3 / 100);
					}
					if (vehicles[i].getVolume() > 200) {
						vehicles[i].setTax(vehicles[i].getValue() * 5 / 100);
					}
					System.out.println("=============================");
				}
				break;
			case 2:
				printTitle();
				System.out.print("\n");
				for (int i = 0; i < vehicles.length; i++) {
					System.out.print(vehicles[i].getHostName());
					printSpace(SPACE + HOST_NAME_LENGTH - vehicles[i].getHostName().length());
					System.out.print(vehicles[i].getModel());
					printSpace(SPACE + MODEL_LENGTH + VOLUME_LENGTH - vehicles[i].getModel().length()
							- String.valueOf(vehicles[i].getVolume()).length());
					System.out.print(vehicles[i].getVolume());
					printSpace(SPACE + VALUE_LENGTH - String.format("%.2f", vehicles[i].getValue()).length());

					System.out.print(String.format("%.2f", vehicles[i].getValue()));

					printSpace(SPACE + TAX_LENGTH - String.format("%.2f", vehicles[i].getTax()).length());
					System.out.println(String.format("%.2f", vehicles[i].getTax()));
				}
				break;
			default:
				return;
			}
			printMenu();
			option = sc.nextInt();
		}
	}
}
