package bai01;

import java.util.Scanner;

public class Student {
	int masv;
	String name;
	float diemLT;
	float diemTH;

	public Student() {

	}

	public Student(int masv, String name, float diemLT, float diemTH) {
		super();
		this.masv = masv;
		this.name = name;
		this.diemLT = diemLT;
		this.diemTH = diemTH;
	}

	public int getMasv() {
		return masv;
	}

	public void setMasv(int masv) {
		this.masv = masv;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "SinhVien [masv=" + masv + ", name=" + name + ", diemLT=" + diemLT + ", diemTH=" + diemTH + "]";
	}

	public void input() {
		Scanner ip = new Scanner(System.in);

		System.out.println("TenSV: ");
		setName(ip.nextLine());
		System.out.println("MaSV: ");
		setMasv(ip.nextInt());
		System.out.println("DiemLT: ");
		setDiemLT(ip.nextFloat());
		System.out.println("DiemTH: ");
		setDiemTH(ip.nextFloat());
	}

	public float diemTB() {
		float diemTB = 0.0f;
		diemTB = (diemLT + diemTH) / 2;
		return diemTB;

	}
}
