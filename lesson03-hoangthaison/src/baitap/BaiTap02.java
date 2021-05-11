package baitap;

import java.util.Scanner;

public class BaiTap02 {

	public static void main(String[] args) {
		Vehice_02 x1 = new Vehice_02();
		Scanner sc = new Scanner(System.in);
		int k = Integer.parseInt(sc.nextLine());
		do {
		System.out.println("----------Menu-------");
		System.out.println("1. Nhập thông tin");
		System.out.println("2. Danh sách xe");
		System.out.println("3. Thoát");
		
		if(k == 1) Nhap();
		if(k == 2) Xuat(x1);
		if(k == 3) return;}
		while(k != 3);

		
		//System.out.println("Tên chủ xe\t Loại xe \t Dung tích \t Trị giá \t Thuế Phải nộp");
		//System.out.println("=====================================================================================================");
		//System.out.println(++);
	}
	private static Vehice_02 Nhap() {
	   Scanner sc = new Scanner(System.in);
	   Vehice_02 x1 = new Vehice_02(
			   sc.nextLine(),
			   sc.nextLine(),
			   Integer.parseInt(sc.nextLine()),
			   Double.parseDouble(sc.nextLine()),
			   Double.parseDouble(sc.nextLine())
			   ); 
	   return x1;
	}
	private static void Xuat(Vehice_02 x1) {
		System.out.println("Tên chủ xe\t Loại xe \t Dung tích \t Trị giá \t Thuế Phải nộp");
		System.out.println("=====================================================================================================");
		System.out.println("" + x1.tenchuxe + "\t" + x1.loaixe + "\t" + x1.trigia + "\t" + Thue(x1) );
		
	}
	private static double Thue(Vehice_02 x1) {
		
		if( 0 <= x1.dungtich && x1.dungtich < 100) {
			return  x1.trigia * 1.0 / 100;
		}if(100 <= x1.dungtich && x1.dungtich < 200) {
			return  x1.trigia * 3.0 / 100;			
		}
		if(x1.dungtich > 200) {
			return x1.trigia * 5.0 / 100;
		}
		return 0;
	}

}
