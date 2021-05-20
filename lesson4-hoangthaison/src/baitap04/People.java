package baitap04;

import java.util.Scanner;

public class People {

	public String hoten;
	public int namsinh;
	public double hesol;
	
	
	public People() {
		// TODO Auto-generated constructor stub
	}
	
	
	public People(String hoten, int namsinh, double hesol) {
		super();
		this.hoten = hoten;
		this.namsinh = namsinh;
		this.hesol = hesol;
	}


	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public int getNamsinh() {
		return namsinh;
	}

	public void setNamsinh(int namsinh) {
		this.namsinh = namsinh;
	}

	
	public double getHesol() {
		return hesol;
	}

	public void setHesol(double hesol) {
		this.hesol = hesol;
	}
	


	@Override
	public String toString() {
		return "People [hoten=" + hoten + ", namsinh=" + namsinh + ", hesol=" + hesol + "]";
	}
	
	public void Nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Họ Tên: ");
		setHoten(sc.nextLine());
		System.out.println("Năm Sinh: ");
		setNamsinh(Integer.parseInt(sc.nextLine())); 
		System.out.println("Hệ số lương");
		setHesol(Double.parseDouble(sc.nextLine()));
	}


}
