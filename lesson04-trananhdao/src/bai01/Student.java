package bai01;

import java.util.Scanner;

public class Student {
	private int maSV;
	private String hoten;
	private float diemLT, diemTH;
	public Student() {
		this.maSV = 0;
		this.hoten = null;
		this.diemLT =0.00f;
		this.diemTH =0;
		
	}
	public Student(int maSV, String hoten, float diemLT, float diemTH) {
		this.maSV = maSV;
		this.hoten = hoten;
		this.diemLT = diemLT;
		this.diemTH = diemTH;
	}
	public int getMaSV() {
		return maSV;
	}
	public void setMaSV(int maSV) {
		this.maSV = maSV;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public float getDiemLT() {
		return diemLT;
	}
	public void setDiemLT(float diemLT) {
		this.diemLT = diemLT;
	}
	public float getDiemTH() {
		return diemTH;
	}
	public void setDiemTH(float diemTH) {
		this.diemTH = diemTH;
	}
	public double DiemTB() {
		return (diemLT+diemTH)/2;
	}
	@Override
	public String toString() {
		return "SinhVien [maSV=" + maSV + ", hoten=" + hoten + ", diemLT=" + diemLT + ", diemTH=" + diemTH + "]";
	}
	public void InputInformation() {
		Scanner s = new Scanner(System.in);
		
		System.out.println("MaSV:");
		setMaSV(Integer.parseInt(s.nextLine()));
		
		System.out.println("ho va ten:");
		setHoten(s.nextLine());
		
		System.out.println("DLT:");
		setDiemLT(Float.parseFloat(s.nextLine()));
		
		System.out.println("DTB:");
		setDiemTH(Float.parseFloat(s.nextLine()));
	}

	

}
