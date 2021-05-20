package bt1;

import java.util.Scanner;

public class Students {
	private int maSV;
	private String name;
	private float diemLT;
	private float diemTH;

	public Students() {
		this.maSV = 0;
		this.name = "";
		this.diemLT = 0;
		this.diemTH = 0;
	}

	public Students(int maSV, String name, float diemLT, float diemTH) {
		this.maSV = maSV;
		this.name = name;
		this.diemLT = diemLT;
		this.diemTH = diemTH;
	}

	public int getMaSV() {
		return maSV;
	}

	public void setMaSV(int maSV) {
		this.maSV = maSV;
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
		return "Students [maSV=" + maSV + ", name=" + name + ", diemLT=" + diemLT + ", diemTH=" + diemTH + "]";
	}

	public void input() {
		Scanner ip = new Scanner(System.in);

		System.out.println("Nhap Thong Tin SV Thu 3");

		System.out.println("MaSV thu 3: ");
		setMaSV(ip.nextInt());
		ip.nextLine();

		System.out.println("Ho Ten SV Thu 3: ");
		setName(ip.nextLine());

		System.out.println("DiemLT SV Thu 3: ");
		setDiemLT(ip.nextFloat());

		System.out.println("DiemTH SV Thu 3: ");
		setDiemTH(ip.nextFloat());

	}

	public float diemTB() {
		float diemTB = 0f;
		diemTB = (this.getDiemLT() + this.getDiemTH()) / 2;
		return diemTB;
	}
}