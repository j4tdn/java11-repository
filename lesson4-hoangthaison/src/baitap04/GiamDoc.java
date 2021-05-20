package baitap04;

import java.util.Scanner;

public class GiamDoc extends People {

	public double hesocv;
	
	
	public GiamDoc() {
		// TODO Auto-generated constructor stub
	}


	public GiamDoc(String hoTen,int namSinh,double heSol, double hesocv) {
		super(hoTen,namSinh,heSol);
		this.hesocv = hesocv;
	}

	public double getHesocv() {
		return hesocv;
	}


	public void setHesocv(double hesocv) {
		this.hesocv = hesocv;
	}


	@Override
	public String toString() {
		return "GiamDoc ["+super.toString()+ ", hesocv=" + hesocv + "]";
	}
	@Override
	public void Nhap() {
		Scanner sc = new Scanner(System.in);
		super.Nhap();
		System.out.println("Hệ số công việc ");
		setHesocv(Double.parseDouble(sc.nextLine()));
	}

	
}
