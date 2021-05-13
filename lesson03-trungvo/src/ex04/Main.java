package ex04;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		
		
//		Vehicle v1 = new Vehicle();
//		System.out.println("Nhap ten chu xe");
//		String tenChuXe = ip.nextLine();
//		System.out.println("Nhap loai xe : ");
//		String loaiXe = ip.nextLine();
//		System.out.println("Nhap tri gia : ");
//		long triGia = ip.nextLong();
//		System.out.println("Nhap dung tich: ");
//		int dungTich = ip.nextInt();
//		
//		v1.setPeopleName(tenChuXe);
//		v1.setCarName(loaiXe);
//		v1.setCc(dungTich);
//		v1.setPrice(triGia);
//		System.out.println(v1);
		
		
		Vehicle v2 = new Vehicle();
		System.out.println("nhap vao ten nguoi mua: ");
		v2.setPeopleName(ip.nextLine());
		
		System.out.println(v2);
	}
}
