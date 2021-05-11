package bai_02;

import java.util.ArrayList;
import java.util.Scanner;

import jdk.swing.interop.SwingInterOpUtils;

public class Menu {
	ArrayList<Vehicle> a = new ArrayList<Vehicle>();
	Scanner s = new Scanner(System.in);

	public Vehicle nhap() {
		System.out.println("nhap ten chu xe, loai xe, dung tich, tri gia:");
		String tenchuxe = s.nextLine();
		String loaixe = s.nextLine();
		int dungtich = Integer.parseInt(s.nextLine());
		long trigia = Long.parseLong(s.nextLine());
		Vehicle v = new Vehicle(tenchuxe, loaixe, dungtich, trigia);
		return v;

	}
	public boolean AddMenu(Vehicle v) {
		return a.add(v);
	}
	public void themmoi() {
		AddMenu(nhap());
	}
	public void inTT(Vehicle v) {
		System.out.printf("%-10s %-10s %-10d %-10d %-10.1f",
				v.getChuxe(), v.getLoaixe(),
				v.getDungtich(), v.getTrigia(),
				v.ThuePhaiNop());
	}
	public ArrayList<Vehicle> getNemu(){
		return a;
	}
	public void inDS() {
		for (Vehicle v : getNemu()) {
			inTT(v);
			System.out.println("");
		}
	}
}